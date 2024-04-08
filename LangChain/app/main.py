import gradio as gr
from template import template
from dotenv import load_dotenv

import time
import datetime

# import api key
load_dotenv()

def response(message, history):
   # 소요시간 측정
   start = time.time()
   result = template.response_chatllm(message)
   end = time.time()
   sec = (end - start)
   print(f"runtime: {datetime.timedelta(seconds=sec)} seconds")
   return result
    
chat = gr.ChatInterface(
   fn=response,
   theme="soft",
   examples=["사원들의 평균 연봉을 구해줘", "각 부서별로 부서이름과 부서의 평균 연봉을 구해줘"],
   title="Query Bot",
)
chat.launch()
# public option : share=True