import asyncio
from typing import AsyncIterable
from fastapi import FastAPI
from fastapi.middleware.cors import CORSMiddleware
from fastapi.responses import StreamingResponse

from langchain.callbacks import AsyncIteratorCallbackHandler
from langchain_openai import ChatOpenAI
from langchain.schema import HumanMessage

from pydantic import BaseModel
import os
from app.config import get_settings

from pathlib import Path
from fastapi.staticfiles import StaticFiles

import webbrowser
import threading

config = get_settings()

os.environ["OPENAI_API_KEY"] = config.OPENAI_API_KEY

app = FastAPI()

app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)



async def send_message(content: str) -> AsyncIterable[str]:
    callback = AsyncIteratorCallbackHandler()
    model = ChatOpenAI(
        streaming=True,
        verbose=True,
        callbacks=[callback],
    )

    task = asyncio.create_task(
        model.agenerate(messages=[[HumanMessage(content=content)]])
    )

    try:
        async for token in callback.aiter():
            yield token
    except Exception as e:
        print(f"Caught exception: {e}")
    finally:
        callback.done.set()

    await task


class Message(BaseModel):
    content: str

@app.post("/stream_chat/")
async def stream_chat(message: Message):
    print(f"message : {message}")
    print(f"message.content : {message.content}")
    generator = send_message(message.content)
    return StreamingResponse(generator, media_type="text/event-stream")

# Get root of app, used to point to directory containing static files
ROOT = Path(__file__).parent.parent
ui_dir = str(ROOT / "frontend/")
if os.path.exists(ui_dir):
    app.mount("", StaticFiles(directory=ui_dir, html=True), name="ui")
else:
    print("main: No UI directory found, serving API only.")

def open_browser():
    webbrowser.open_new("http://127.0.0.1:8000")

if __name__ == "__main__":
    threading.Timer(1.25, open_browser).start()  # 1.25초 후에 브라우저를 엽니다.
    import uvicorn
    uvicorn.run("main:app", host="0.0.0.0", port=8000, proxy_headers=True, forwarded_allow_ips="*")