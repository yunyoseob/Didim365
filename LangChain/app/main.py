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
   # RAG 구성
   result = template.response_rag_chatllm(message)
   end = time.time()
   sec = (end - start)
   print(f"runtime: {datetime.timedelta(seconds=sec)} seconds")
   return result
    
chat = gr.ChatInterface(
   fn=response,
   theme="soft",
   examples=["Calculate the average salary of employees", "Calculate the department name and the average salary of each department.","Calculate the average price of cars"],
   title="Query Bot",
)
chat.launch()
# public option : share=True