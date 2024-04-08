from langchain.prompts import PromptTemplate
from langchain.chains import LLMChain
from langchain_openai import OpenAI
import os

# 프롬프트 템플릿 만들기
prompt = PromptTemplate(
    input_variables=["product"],
    template="{product}을 만드는 새로운 한국어 회사명을 하나 제안해 주세요.",
)

# 프롬프트 생성
# print(prompt.format(product="가정용 로봇"))

# 체인 생성
chain = LLMChain(
    llm = OpenAI(temperature=0.9),
    prompt=prompt
)

# 체인 실행
chain.run("가정용 로봇")
