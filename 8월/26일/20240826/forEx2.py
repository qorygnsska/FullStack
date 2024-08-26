
# 파이썬에서만 사용할 수 있는 for문
# list() 형 변환
# list1 = list(range(10))
# print(list1)

# 리스트를 생성할 때 반복문을 이용해서 리스트를 생성할 수 있다.
# list2 = [i for i in range(1, 6)]
# 실행 순서
# 1. range(1, 6)  1부터 5까지의 숫자를 생성
# 2. 생성된 숫자를 순서대로 꺼내와서 i에 저장
# 3. 저장된 값을 이용해서 리스트를 생성

'''
리스트 컴프리헨션
    - 파이썬에서 리스트를 간단하게 한줄로 선언
    - 리스트 생성 시 코드의 가독성을 높여준다.
    [data for item in iterable]
    data : 값이 들어온다
    item : 현재 반복되고 있는 값
    iterable : 리스트, 숫자범위, 문자열...

# print(list2)

list1 = ['a', 'b', 'c']

upperList = [str.upper() for str in list1]
print(upperList)

# 짝수만 리스트에 포함
# 1부터 10까지 숫자 중에서 짝수만!
numbers = [i for i in range(1, 11) if i % 2 == 0]

# 1. range() 범위값 반환
# 2. 범위값에서 하나씩 꺼내서 i에 저장
# 3. 조건검사 이때 True이면 리스트에 포함한다.
print(numbers)

# -6부터 10까지 반복을 하는데 홀수만 리스트에 저장하기!
list3 = [i for i in range(-6, 11) if i % 2 == 1]
print("정수형 : ", list3)

list4 = [str(i) for i in range(-6, 11) if i % 2 == 1]
print("문자형 : ", list4)
# 숫자 -> 문자로 변경해서 저장 str()
# 문자 -> 숫자(정수) int()


# 구구단을 for문을 이용해서 range로 2~9단까지 출력
for i in range(2, 10) :
    print(i, "단 : ", end='')
    for j in range(1, 10) :
        print(i * j, end=' ')
    print()

# 한줄로 작성
guguddan = [
    [i * j for j in range(1, 10)] for i in range(2, 10)
]

# start 속성을 이용해서 index 값을 지정할 수 있다. 기본적으로 0
# join()
# map(str, value)
# 여러개의 문자를 각각의 타입으로 변환 X
for index, value in enumerate(guguddan, start=2) :
    print(f"{index}단 : {value}")

'''
# 여러개의 데이터를 입력 받아서 각각의 데이터로 리스트에 저장
user = input("여러개 데이터 : (10 1.1 st)")
# 결과를 저장할 리스트 생성
values = []
# 입력 문자를 공백으로 분리해서 값을 저장
for i in user.split(' ') :
    if i.isdigit() :
        # isdigit() 정수로 변환 가능하니?
        values.append(int(i))
    elif '.' in i and i.replace('.', '', 1).isdigit() :
        values.append(float(i))
    else :
        values.append(i)
print(values)

# 예외처리를 이용해서 여러 데이터를 입력받는다.
def value(val) :
    try :
        # 실행할 문장
        # 정수형 변환이 되면 정수형 리턴
        print("정수형")
        return int(val)
    except ValueError :
        pass

    # 실수형태로 형변환이 되면 실수형 리턴
    try :
        print("실수형")
        return float(val)
    except ValueError :
        pass

    return val

values = list(map(value, user.split()))

print(values)

# input() 문자
# int(input()) 정수
# float(input()) 실수