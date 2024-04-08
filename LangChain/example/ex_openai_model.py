<<<<<<< HEAD
import os
from langchain_community.llms import OpenAI

# LLM 준비
llm = OpenAI(
    model_name="gpt-3.5-turbo-instruct",
    temperature=0.9
)

# LLM 호출
result = llm("Hi, What is your name?")

=======
import os
from langchain_community.llms import OpenAI

# LLM 준비
llm = OpenAI(
    model_name="gpt-3.5-turbo-instruct",
    temperature=0.9
)

# LLM 호출
result = llm("Hi, What is your name?")

>>>>>>> 8b4cba7350fad215da40744eeb1bdb2fd83715cc
print(f"result > :  {result}")