
# for문
# 횟수가 정해져있거나 반복해야되는 대상
'''
for 변수 in 객체 :
    실행문
    실행문

 문자열, 리스트

 for y in 10 :
    print(y)
 숫자형 데이터는 들어올 수 없다
 여러개의 데이터를 가지고 반복을 자동으로
 수행할 때 사용하는 반복문!
'''

# for x in 'abc' :
#     print(x)

# for v in ['1', '2', '3'] :
#     print(v)

# for v in [[1, 2], [3, 4], [5, 6]] :
#     print(v)

# 1 ~ 5까지 출력! for
# 숫자의 범위를 반환하는 range(시작, 끝 - 1)
# 끝나는 숫자는 데이터를 포함하지 않는다
# for i in range(1, 5) :
#     print(i)

# 1 ~ 50까지 2씩 증가
# range(시작, 끝 -1, 증감크기)
# for i in range(1, 51, 2) :
#     print(i)

# 5, 4, 3, 2, 1
# for i in range(5, 0, -1) :
#     print(i)

# 리스트의 값과 인덱스를 같이 출력
proList = ['java', 'spring', 'html']

# for문으로 반복을 하면 값이 온다.
# 값과 같이 인덱스(공간의 번호)
# enumerate() 실행하면 두개의 변수가 필요하다.

for index, value in  enumerate(proList) :
    print("공간 : ", index)
    print("값 : ", value)


# 두 개의 리스트를 동시에 반복
nameList = ['이서희', '이익준', '김준완']
ageList = [20, 30, 40]
# 혈액형 리스트 넣고 zip 이용해서 출력
bloodList = ['A', 'B', 'O']

for name, age, blood in zip(nameList, ageList, bloodList) :
    print(f"{name} 나이 : {age} 혈액형 : {blood}")


print("=" * 20)
print()

# 1부터 5까지 출력 3은 건너뛰기
# 1 2 4 5
for i in range(1, 6) :
    if i == 3:
        continue
    print(i)

# 3이 나오면 반복 끝내기
# 1 2 4 5
for i in range(1, 6) :
    if i == 3:
        break
    print(i)


