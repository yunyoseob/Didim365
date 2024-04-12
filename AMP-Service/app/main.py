from fastapi import FastAPI
from backend.routers.service_router import service_router
from fastapi.responses import FileResponse
import os

app = FastAPI()

# main page로 연결
@app.get("/", response_class=FileResponse)
async def main_page():
    file_path = os.path.join(os.path.dirname(__file__), "./frontend/index.html")
    with open("./frontend/index.html") as f:
        return FileResponse(file_path, media_type="text/html")

app.include_router(service_router)

if __name__ == "__main__":
    import uvicorn
    uvicorn.run("main:app", host="127.0.0.1", port=8000, proxy_headers=True, forwarded_allow_ips="*")