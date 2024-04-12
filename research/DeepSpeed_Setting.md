# DeepSpeed Setting & Test

작은 모델부터 실습 진행

```
Vanlila Transformer
BERT
BART
LLaMa
...
```

✔ Requirement

1. Fine Tuning시, 속도와 리소스를 모니터링 하여 비교 필요

2. 기존 Fine Tuning보다 속도가 빠르다고 한다면, 타 병렬 GPU 모델 연산에 비해 효과가 있는지 체크 필요

[참고자료1: Huggingface + DeepSpeed + FairScale](https://junbuml.ee/huggingface-deepspeed-fairscale)

[참고자료2: Transformers와 DeepSpeed로 새 BERT 모델 굽기](https://junbuml.ee/transformers-deepspeed-new-bert-model)

환경 세팅

```
# Version Check 

PyTorch >= 1.8.0
Transformers >= 4.6.0
```

