
# 파이썬에서 랜덤 파일을 가지고와서 랜덤값을 출력
import random

# 정수값 출력
# randint(시작, 끝)
# 시작과 끝이 데이터를 포함!
rand = random.randint(1, 3)
print(rand)

# 리스트에서 랜덤으로 값을 선택
items = ['python', 'java', 'spring', 'html']

# choice(리스트)
# 리스트안에 데이터 중에서 하나를 뽑는다.
rand_item = random.choice(items)
print(rand_item)

# 위에 하나의 데이터만 출력
# 중복적으로 2개 이상 출력할 때
# choices(리스트, k=데이터 개수!)
rand_item2 = random.choices(items, k=3)
print(rand_item2)

print("섞기 전", items)
# 리스트 섞기
random.shuffle(items)
print(items)

num = 7

str_num = str(num).zfill(3)
print(str_num)
