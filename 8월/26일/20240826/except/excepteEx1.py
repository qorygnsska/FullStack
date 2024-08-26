
# 파이썬 예외처리
'''
try :
    예외 발생 문장
excpet :
    예외를 처리하는 문장
'''
try :
    result = 10 / 0
except ZeroDivisionError as e :
    # print("0으로 안돼")
    print(e) # division by zero


# 여러 예외처리
try :
    result = int('abc')
except(ValueError, TypeError) :
    print("타입 에러 및 값 에러!")


try :
    result = int(input('정수'))
except Exception as e :
    print(e)

# 문자열의 길이를 값으로 딕셔너리 생성
try :
    words = ['apple', 'banana', 'cherry']
    lengths = {w : len(w) for w in words}
except Exception as e :
    print(e)


# 딕셔너리를 이용해서 짝수를 저장하는 딕셔너리 생성
numbers = range(10)

even = {n : n**2 for n in numbers if n % 2 == 0}
print(even)

# 문자열에서 대문자로만 키를 사용
string = "Hello World"

try :
    dict1 = {char : char.lower() for char in string if char.istupper()}
except Exception as e :
    print(e)


keys = ['name', 'age', 'city']
values = ['Alice', 25, 'New York']

try :
    dict3 = {keys[i] : values[i] for i in range(len(keys))}
    print(dict3)
except Exception as e :
    print(e)
finally : # 예외발생 하든 안 하든 무조건
    print("와! 퇴근이다!")
# 결과
# {'name' : 'Alice', 'age' : 25, 'city' : 'New York'}

# else : 예외없이 성공했을 때
# finally : 예외가 있던 없던 무조건 실행
try :
    print(10 / 1)
except Exception :
    print("예외발생")
else :
    print("오~ 예외 없는데!")
finally :
    print("있든 없든 예외 출력!")

# raise 강제적으로 예외를 발생시키는 것!
def test(a, b) :
    if a== 0 or b == 0 :
        raise ZeroDivisionError
    return a / b

# main에서 처리하기
try :
    test(10, 0)
except Exception as e :
    print(e)
else :
    print("성공했는데?")
finally :
    print("운 좋네 ㅋ")
  