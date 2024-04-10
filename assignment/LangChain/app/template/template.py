from langchain.chains import LLMChain
# from langchain_openai import OpenAI
from langchain.chains import RetrievalQA
from langchain_openai import ChatOpenAI
from langchain.schema import (
    SystemMessage,
    HumanMessage,
    AIMessage
)
from retrieve import create_retriever
from langchain.prompts import PromptTemplate
from langchain.memory import ConversationBufferMemory
from langchain.chains import ConversationChain
import os
import json

"""
Query Bot
"""
def response_query_chatllm(question):
    print(f"prompt question : {question}")
    
    # langchain model (ChatOpenAI)
    chat_llm = ChatOpenAI(temperature=0.8)
    
    messages = [
        HumanMessage(content=question),
        SystemMessage(content="""
                        You're a chatbot that writes queries. Based on the user's question, write a query in Oracle's ANSI syntax.
                        Query: {question}
                        Answer:
                      """)
    ]

    # 체인 실행
    result = chat_llm(messages)
    answer = result.content
    print(f"prompt answer : {answer}")
    return answer


def response_query_rag_chatllm(question):
    print(f"prompt question : {question}")

    # RAG
    retriever = create_retriever.create_rag(question)
    print(f"retriever : {retriever}")

    # Lang Chain
    qa_chain = RetrievalQA.from_chain_type(
        llm=ChatOpenAI(temperature=0.8),
        chain_type="stuff",
        retriever=retriever,
        return_source_documents=True
    )

    # Chain of Tought prompt
    messages = f"""
    Let's think step by step. 
    1. Find the most suitable retriever for writing the query based on the user's requirements. 
    2. Write a query for the answer by reading the user's question, involving one or more tables. 
       The user's question is stated below.
       Query: {question}
       Answer:
    """

    print(f"prompt message : {messages}")
    result = qa_chain(messages)

    # 결과와 결과 참고 소스 출력
    for source in result["source_documents"]:
        print(f"source_documents : {source.metadata['source']}")
    answer=result['result']

    print(f"prompt answer : {answer}")
    return answer

"""
Conversation Bot
"""
def response_conversation_chatllm(question):
    print(f"prompt question : {question}")

    # 메모리 변수 가져오기
    save_memory = str(get_memory_file())

    chat_llm = ChatOpenAI(temperature=0.8)
    memory = ConversationBufferMemory(return_messages=True)
    conversation = ConversationChain(
            llm=chat_llm,
            memory=memory
    )

    save_memory = save_memory + " " + question
    print(f"make prompt : \n {save_memory}")

    answer = conversation(save_memory)['response']
    print(f"prompt answer : {answer}")

    memory.chat_memory.add_user_message(question)
    memory.chat_memory.add_ai_message(answer)

    buffer_str = str(memory.buffer)
    save_memory = save_memory + " " + buffer_str

    save_memory_file(save_memory)
    return answer

def save_memory_file(save_memory):
    current_directory = os.getcwd()
    save_file = os.path.join(current_directory, "./resources/history/chat_history.txt")
    with open(save_file, "w", encoding="utf-8") as f:
        f.write(save_memory)

def get_memory_file():
    current_directory = os.getcwd()
    get_file = os.path.join(current_directory, "./resources/history/chat_history.txt")
    if os.path.exists(get_file):
        with open(get_file, "r", encoding="utf-8") as f:
            return f.read()
    else:
        return ""