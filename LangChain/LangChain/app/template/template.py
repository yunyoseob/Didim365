from langchain.prompts import PromptTemplate
from langchain.chains import LLMChain
from langchain_openai import OpenAI
from langchain.chat_models import ChatOpenAI
from langchain.schema import (
    SystemMessage,
    HumanMessage,
    AIMessage
)

def response(question):
    print(f"run prompt message > question : {question}")
    # 랭체인 생성(ChatOpenAI)
    chat_llm = ChatOpenAI(temperature=0.9)
    
    # LLM 호출
    messages = [
        HumanMessage(content=question),
        SystemMessage(content="You are a chatbot that generates queries from the EMP table based on ORACLE ANSI syntax, analyzing user questions and providing queries accordingly.")
    ]

    # 체인 실행
    result = chat_llm(messages)
    answer = result.content
    return answer