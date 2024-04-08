from langchain.chat_models import ChatOpenAI
from langchain.schema import (
    SystemMessage,
    HumanMessage,
    AIMessage
)

# LLM 준비
chat_llm = ChatOpenAI(temperature=0.9)

# LLM 호출
messages = [
    HumanMessage(content="고양이 울음소리는?")
]

result = chat_llm(messages)
print(result)