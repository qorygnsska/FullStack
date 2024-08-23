# 주석
# 확장자 : .py

# 출력
print(10)
print(20.10)

# 한 문자든 문자열이든 ' ' 또는 " "
print("헬로우!")
print('헬로')
print("d")
print('f')

# print() 기본적으로 줄바꿈 적용!
# 5 4 3 2 1
print(5, 4, 3, 2, 1, sep='')
print(5, 4, 3, 2, 1, sep='!')
print(5, 4, 3, 2, 1, sep='/ ')
print(5, 4, 3, 2, 1, sep='@')

print(5, 4, 3, 2, 1)

# 자동으로 포함되는 줄바꿈을 삭제
print(5, end=' ')
print(4, end=' ')
print(3, end='')
print(2, end='')
print(1, end='')

# sep, end 함께 사용
# 파이썬은 세미콜론이 없다!
# 명령문은 무조건 한줄에 작성을 해야된다.
print('이서희', 20, 'A', '강남', sep='/', end=' ')
print()
print('이서희', 20, 'A', '강남', sep='@', end=' ')

print("작성할 수 없는데?")
print(''' 
    hello
    안녕
    집에 가고싶다.
''')

print("""
    hello
    안녕
    집에 가고싶다.
""")