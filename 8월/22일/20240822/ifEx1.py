#파일명: ifEx1.py

# 참과 거짓을 저장하는 타입 bool
result = True
result2 = False
print(type(result))

# 들여쓰기 기준이 4칸 
if result :
    if result2 :
        print("참이면 실행@")

# 백화점에서 여러 물품을 구매했다.
# 구매한 물품이 총합이 10만원이상이면 상품권 
#  수령 가능!
#  30000 , 50000 , 15000 , 25000

total = 30000 + 50000 + 15000 + 25000

if total >= 100000 :
    #참이면 실행
    print("상품권 수령 가능!")

if total < 100000 :
    print(" 상품권 수령 불가능!")

# 나이를 입력 받아서 버스 요금을 출력
#  20세 이상이면 요금 2800원
#    미만이면 무료 65세 이상 무료
age = 25
if age >= 20:
    print("요금 2800원")
else : 
    print("무료!")

# or 또는  둘 중 하나만 참이면 실행!
if age < 20 or age >= 65:
    print("무료!")
else : 
    print("요금 2800원")

# 90부터 100 사이 범위 안에 들어오는 숫자는
# A

num = 95
if num >= 90 and num <= 100:
    print("A")
else:
    print("F")