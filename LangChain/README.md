# LangChain

## 1. LangChain framework을 기반으로 OpenAPI API를 이용한 Chat UI 기능 구현

- Gradio나 Streamit 등을 이용하여 챗 화면 구성

- 이전 대화 맥락 유지하도록 prompt 구성

## 2. Hugging Face library 기반으로 sLLM 모델 기반 chat 기능 구현 및 학습


(참고1) [All About TinyLlama 1.1B - Analytics Vidhya](https://www.analyticsvidhya.com/blog/2024/01/tinyllama-b-size-doesnt-matter/)

(참고2) [SQL Generation in Text2SQL with TinyLlama's LLM Fine-tuning (analyticsvidhya.com)](https://www.analyticsvidhya.com/blog/2024/02/sql-generation-in-text2sql-with-tinyllamas-llm-fine-tuning/)


## LLM Chat Test

```
http://localhost:7860/
```


```
- LLM: LLM 호출을 위한 공통 인터페이스

- 프롬프트 템플릿: 사용자 입력에 따른 프롬프트 생성

- 체인: 여러 LLM과 프롬프트의 입출력을 연결

- 에이전트: 사용자의 요청에 따라 어떤 기능을 어떤 순서로 실행할 것인지 결정

- 도구: 에이전트가 수행하는 특정 기능

- 메모리: 체인 및 에이전트의 메모리 보유
```
