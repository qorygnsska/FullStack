'''
num = 1
while num != 6:
    print(num)
    num += 1
'''
'''
start = 1
while start <= 5 :
    print("*" * start)
    start += 1
'''

'''
tree = 1
while tree <= 10:
    print("나무를", tree, "번 찍었다.")
    tree += 1
'''

'''
dan = 2;
while dan <= 9 :
    print(dan, "단 : ", end='')
    num = 1;
    while num <= 9:
        print(dan * num, end=' ')
        num += 1
    print()
    dan += 1
'''

'''
# 이름과 문제개수를 입력
# input() 함수는 입력을 받으면 모두 문자로 반환
name = input('이름 : ')
count = int(input("문제 개수 : "))

# 문제를 푼 개수를 저장
totalCount = 0

# 문제 개수만큼 반복문을 작성하면 된다.
start = 1
while start <= count :
    save = input(f'{start}번 문제를 해결했니?')
    print(save)

    # 사용자 입장에서 y, Y
    save = save.lower()

    if save == 'y':
        totalCount += 1

    start += 1
print(name, "학생", totalCount, "개 문제 해결했네요")
'''




    