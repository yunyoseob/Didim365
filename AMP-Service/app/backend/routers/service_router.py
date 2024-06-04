from fastapi import APIRouter, Request

service_router = APIRouter()

service_list = []

service_dict = {
    "Domain" : "사내규정에는 뭐가 있지?",
    "Tech":"기술문서에는 어떤 내용들이 있어?",
    "AIMSP":"AIMSP에서 사용하는 LLM은?",
    "PROD_RULE":"주차 지원에 대한 규정이 어떻게 되지?"
}

# http -v GET http://127.0.0.1:8000/service
@service_router.get("/service")
async def get_service(service_id: str):
    print(f"service_id : {service_id}")
    output_text = service_dict[service_id]
    return {
        "output_text":output_text
    }

