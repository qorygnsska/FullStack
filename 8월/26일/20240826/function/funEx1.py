'''
# 함수
# 입력값을 받아 출력값을 반환하는 코드의 묶음
# def 함수명(매개변수) :
#   실행할 문장
#   return 값

# 함수의 매개변수한테 기본값을 설정
# 기본값을 설정하면 값이 안 들어왔을 때 기본값으로 처리
def info(name="윤서", age = 0) :
    print("이름 : ", name)
    print("나이 : ", age)

# 함수 실행
info("배교훈", 20)
info("배교훈")
info()

# 매개변수 이름을 지정해서 넘길 수 있다
# 순서에 신경 안써도 됨
info(age = 25, name ="이익준")

# 더하기
def add(a = 0, b = 0) :
    if a == 0 and b == 0 :
        return "0을 입력해서 계산 못함!"
    return a + b

result = add()
print(result)

result2 = add(2, 5)
print(result2)
'''

def longest(a, b, c) :
    sizeA = len(a)
    sizeB = len(b)
    sizeC = len(c)

    if sizeA >= sizeB and sizeA >= sizeC :
        return a
    elif sizeB >= sizeA and sizeB >= sizeC :
        return b
    else :
        return c

def longe(a, b, c) :
    # return max(a, b, c) 알파벳 순서로 비교
    return max(a, b, c, key=len)

def short(a, b, c) :
    return min(a, b, c, key=len)
print(longe("one", "second", "three"))
print(short("one", "second", "three"))

proList = ['java', 'springboot', 'htmml5']
# 리스트에서 가장 문자열이 긴 단어를 출력, 가장 문자열이 작은 단어를 출력

