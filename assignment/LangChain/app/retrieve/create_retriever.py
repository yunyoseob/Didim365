from langchain.text_splitter import RecursiveCharacterTextSplitter
from langchain_community.vectorstores import Chroma
from langchain_openai import OpenAIEmbeddings
from langchain_community.document_loaders import TextLoader
from langchain_community.document_loaders import DirectoryLoader
import os

def create_rag(question):
    current_directory = os.getcwd()
    directory = os.path.join(current_directory, "./resources/docs")
    vector_db = read_txt_files(directory)
    try:
        if vector_db is not None:
            retriever = get_retriever(vector_db=vector_db, question=question)
        else:
            raise ValueError("vector db is none")
    except ValueError as e:
        print("create rag error : ", e)
    return retriever

# text files를 쪼갠 뒤, Vector DB에 insert    
def read_txt_files(directory):
    file_list = os.listdir(directory)
    print(f"directory : {directory}, file list : {file_list}")

    # Document Load
    raw_documents = DirectoryLoader(directory, glob="*.txt", loader_cls=TextLoader).load()
    
    # Chunk Spliter
    text_splitter = RecursiveCharacterTextSplitter(
            chunk_size = 100, # Chunk Split Number
            chunk_overlap = 0
    )

    # Text Split
    documents = text_splitter.split_documents(raw_documents)

    # Chroma DB
    persist_directory='./resources/chromadb'

    # Insert Vector DB
    vector_db = Chroma.from_documents(
        documents=documents, 
        embedding=OpenAIEmbeddings(),
        persist_directory=persist_directory
    )
    return vector_db

# Get Retriever
def get_retriever(vector_db, question):
    retriever = vector_db.as_retriever(search_kwargs={"k": 3})
    docs = retriever.get_relevant_documents(question)
    for doc in docs:
        print(doc.metadata["source"])
    return retriever