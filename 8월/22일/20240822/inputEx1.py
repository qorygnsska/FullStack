# 파일명: inputEx1.py
'''
# input()
# 입력한 모든 문자가 str 타입으로 저장
str1 = input('정수:')
print(type(str1))

#문자를 숫자로 변경
str1 = int(str1)

print(type(str1))
print(str1 + 10)

# 정수 
age = int(input('나이  >'))

# 실수 
hei = float(input('키 >'))

# 문자 
string = input('아무문자나 입력>')

# 더하기 
# 문자 + 문자 = 연결 
# 문자 + 숫자 = 에러!

# 곱하기
# 문자열 복사!
print("hello" * 5)

# *****
print("*" * 5)

# map(변환할 타입, input().split()) 
# 여러개를 한 번에 입력받고 싶을 때 
list1 = input('여러개의 문자를 입력:') \
        .split(' ')

print(list1)
'''
# 파이썬에서 여러개의 변수를 저장 
a = 10; b = 20

a,b = b,a

print(a)
print(b)
# 값 교체 
#temp = a
#a = b
#b = a


c = 100; d = 20; e = 30

# 파이썬만의 여러 변수 선언
a1 , b1 , c1 = 1000,2000,3000

print(a)
print(c)
print(a1,b1,c1)

# 형변환
# int() , float() , str()

# 산술연산자 
# 나눗셈 몫 
print("나눗셈 몫: ", 100 / 10)  #결과 실수
print("나눗셈 몫: ", 100 // 10) #    정수

# 증감 연산자 못씀
# 복합연산자 가능!
a += 1

str3 = "hello"
print("변경 전 문자:" ,str3)

str3 = str3.upper()
print(" 모두 대문자:" , str3)
print("변경 후 문자:" ,str3)

# 문자열의 길이,배열의 길이
size = len('python java springboot')
print("문자열의 길이:",size)

list2 = ['python', 'java', 'spring']
print(len(list2))