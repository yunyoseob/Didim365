# from langchain.chains import LLMChain
# from langchain_openai import OpenAI
from langchain.chains import RetrievalQA
from langchain_openai import ChatOpenAI
from langchain.schema import (
    SystemMessage,
    HumanMessage,
    AIMessage
)
from retrieve import create_retriever

def response_chatllm(question):
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


def response_rag_chatllm(question):
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