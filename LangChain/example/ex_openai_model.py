import os
from langchain_community.llms import OpenAI

# LLM 준비
llm = OpenAI(
    model_name="gpt-3.5-turbo-instruct",
    temperature=0.9
)

# LLM 호출
result = llm("Hi, What is your name?")

print(f"result > :  {result}")