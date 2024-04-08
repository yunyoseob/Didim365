import gradio as gr
from template import template

def response(message, history):
   result = template.response(message)
   return result
    
# demo = gr.Interface(fn=response, inputs="text", outputs="text")
# demo.launch()
chat = gr.ChatInterface(
   fn=response,
   theme="soft",
   examples=["사원들의 평균 SAL을 구해줘"],
   title="Query Bot",
)
chat.launch()
##share=True