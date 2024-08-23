'''
# 리스트(list)
# 배열 : 하나의 타입으로 여러개를 저장
# 클래스 : 다른 타입으로 타입 만들고 여러개 저장

# 리스트 생성시 []
# 여러개 저장
# 인덱스 사용가능 0부터
# 순서가 있는 자료구조(순차적인 자료구조)
list1 = [1, 2, 3, 4]
list2 = [1.1, 2.2, 3.3]
list3 = ["a", "b", "c"]

list4 = [1, "python", 10.12345]

print(list1)
print(list2)
print(list3)
print(list4)

# 데이터 접근
print(list4[0])
print(list4[1])
print(list4[2])

# 파이썬만의 리스트 접근 방법
# 오른쪽에서 부터 인덱스를 이용해서 접근 가능
# 오른쪽에서는 음수값을 이용해서 인덱스를 지정
print(list4[-1])
print(list4[-2])
print(list4[-3])


# 빈 리스트
list5 =[]
print(list5)

# 비어있는 리스트는 저장할 공간이 없다!
# append()
# 하나의 값만 맨 마지막에 추가함
list5.append(10)
print(list5)
list5.append(20)
print(list5)
list5.append(30)
print(list5)

# 여러개를 추가
list5.append([40, 50, 60])
print(list5)
print(list5[3])
print(list5[3][0])

# 리스트안에 리스트를 저장
list6 = [
    [1, 2, 3],
    [1.1, 2.2, 3.3],
    ["python", "java", "spring"]
]
print(list6)

# [1, 2, 3] 중에서 2를 출력
print(list6[0][1])
# [1.1, 2.2, 3.3] 중에서 3.3을 출력
print(list6[1][2])
# ["python", "java", "spring"] python 출력
print(list6[2][0])

# 2차원 배열과 비슷하다
numberList = [1, 2, 3, 4, 5]
print(numberList)

# insert(인덱스, 값)
numberList.insert(2, 6)
print(numberList)

numberList.insert(0, "hello")
print(numberList)

# 여러개를 각각 저장할 때
nameList = ["이익준"]
# []괄호를 하는 이유는 여러개의 데이터를 어떤 타입으로 저장
nameList.extend(["김준완", "양석형"])
print(nameList)


# 수상자 명단
winner = ['박미아', '정민호', '김철수', '이영희', '손소정']

# 검색할 명단
checkName = ['정수지','김철수','박민아','전은진']

# in , not in
# 결과 값이 True, False
# 리스트 안에 검색하는 값이 있니? in 연산자
print('정수지' in winner)

# 리스트 안에 검색하는 값이 없니? not in 연산자
print('정수지' not in winner)

# 반복문하고 index번호를 이용해서 체크하는
# 명단을 수상자 명단에서 확인하기 
# len(리스트명)
# 리스트의 길이를 반환한다. 

index = 0
while index < len(checkName):
    name = checkName[index]

    if name in winner:
        print(f"{name}가 수상했는지 확인해라.")
    else:
        print(f"{name}가 수상하지 못했는지 확인해라.")

    index += 1
'''

products = [
    ["비누", 3, 2],
    ["칫솔", 5, 4],
    ["샴푸", 2, 1],
    ["치약", 4, 4],
    ["로션", 5, 3]
]
size = len(products)
index = 0

while index < size :
    pro = products[index][0]
    sales = products[index][1]
    cust = products[index][2]

    if sales >= 4 and cust >= 4 :
        print(pro + " 우수 상품")
    else :
        print(pro + " 판매 중지")
    
    index += 1



