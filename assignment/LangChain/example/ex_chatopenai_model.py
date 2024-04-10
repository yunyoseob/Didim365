<<<<<<< HEAD
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
=======
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
>>>>>>> 8b4cba7350fad215da40744eeb1bdb2fd83715cc
print(result)