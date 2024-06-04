# fruit_list.py
from __future__ import division
import os
import psutil
import random
import time
 
names = ['사과', '배', '참외', '딸기', '바나나', '수박']
 
process = psutil.Process(os.getpid())
mem_before = process.memory_info().rss / 1024 / 1024
 
def fruit_list(num_fruit):
  result = []
  for i in range(num_fruit):
    fruit = {
        'id': i,
        'name': random.choice(names),
    }
    result.append(fruit)
  return result


t1 = time.time()

# 10만번 랜덤으로 호출
fruits = fruit_list(1000000)

# 리스트를 사용하여 for loop 실행
for fruit in fruits:
  if fruit['id']==99999:
    print(fruit)

# 리스트를 사용하여 for loop 실행
for f in fruit:
  print(f)

t2 = time.time()
mem_after = process.memory_info().rss / 1024 / 1024
total_time = t2 - t1


print('시작 전 메모리 사용량: {} MB'.format(mem_before))
print('종료 후 메모리 사용량: {} MB'.format(mem_after))
print('총 소요된 시간: {:.6f} 초'.format(total_time))