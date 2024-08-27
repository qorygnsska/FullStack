# #파일명: classTest.py

# # 252
# class Human:
#     pass

# # 253 
# areum = Human()
# print(areum)

# # 254
# class Human2:
#     def __init__(self):
#         print("응애응애")

# h1 = Human2()

# # 255
# class Human3:
#     def __init__(self,name,age,g):
#         self.name = name
#         self.age = age
#         self.g = g

#     def __str__(self):
#         return f"이름:{self.name},나이:{self.age} , 성별:{self.g}"
   
#     # 260번 에러 원인!
#     # 클래스 멤버 메서드는 무조건 매개변수
#     # 첫번째는 자기 자신의 주소값 받아야된다.
#     def who(self):
#         print("이름{} 나이:{} 성별:{}"\
#             .format(self.name,self.age,self.g))

#     # 258번 코드 
#     def setInfo(self,name,age,g):
#         self.name = name
#         self.age = age
#         self.g = g
#         print("수정됨")



# ar = Human3("이름",25,"여자")
# print(ar.name)

# # 255 객체를 이용해서 값 출력

import random as r
# 271
class Account :
    # 클래스 변수
    acc_count = 0
    
    def __init__(self, name, accNum=0) :
        self.name = name
        # self.accNum = accNum

        num1 = r.randint(0, 999)
        num2 = r.randint(0, 99)
        num3 = r.randint(0, 9999999)

        # zfill(width)
        # - 문자열의 길이를 지정하고 데이터를 채운다
        # - 만약 부족한 길이는 0으로 채운다.
        
        num1 = str(num1).zfill(3)
        num2 = str(num2).zfill(2)
        num3 = str(num3).zfill(6)

        self.accNum = num1 + '-' + num2 + '-' + num3

        print("계좌번호 : ", self.accNum)

        # 클래스변수 증가
        Account.acc_count += 1

acc = Account("카카오뱅크")
print("현재 계좌 개수 : ", Account.acc_count, "개")

# 261 ~ 264
class Stock :
    pass

class Stock2 :
    def __init__(self, name, code) :
        self.name = name
        self.code = code

    def __str__(self) :
        return f"{self.name}, {self.code}"
        

    def set_name(self, name) :
        self.name = name

    # 코드수정하는 메서드
    def set_code(self, code) :
        self.code = code


st = Stock2("삼성전자", "005930")
print(st)

st.set_name("현대")
print(st)

# 객체지향 언어 접근제한자
# public, private 지원 안함
class MyClass :
    
    def __init__(self) :
        self.__name = "private"

    def getName(self) :
        return self.__name
my = MyClass()
print(my.getName())

# Protected
# 자식 클래스만 접근 가능함
# _변수명