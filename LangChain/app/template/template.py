# from langchain.chains import LLMChain
# from langchain_openai import OpenAI
from langchain.chat_models import ChatOpenAI
from langchain.schema import (
    SystemMessage,
    HumanMessage,
    AIMessage
)
def response_chatllm(question):
    print(f"prompt question : {question}")
    
    # langchain model (ChatOpenAI)
    chat_llm = ChatOpenAI(temperature=0.0)
    
    # LLM 호출
    messages = [
        HumanMessage(content=question),
        SystemMessage(content="""
                        You are a chatbot that generates queries from the table based on ORACLE ANSI syntax, analyzing user questions and providing queries accordingly.
                        Query: {question}
                        Answer:
                      """)
    ]

    # 체인 실행
    result = chat_llm(messages)
    answer = result.content
    print(f"prompt answer : {answer}")
    return answer