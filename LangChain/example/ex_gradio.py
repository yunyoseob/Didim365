<<<<<<< HEAD
import gradio as gr

def greet(name):
    return "Hello" + name + "!"

demo = gr.Interface(fn=greet, inputs="text", outputs="text")

=======
import gradio as gr

def greet(name):
    return "Hello" + name + "!"

demo = gr.Interface(fn=greet, inputs="text", outputs="text")

>>>>>>> 8b4cba7350fad215da40744eeb1bdb2fd83715cc
demo.launch()