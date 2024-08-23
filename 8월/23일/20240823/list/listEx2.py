#파일명: listEx2.py
'''
# 여러개의 리스트 값을 꺼낼 때
# 슬라이싱 
# 원하는 값을 일부분을 추출한다.
list1 = [1,2,3,4,5,6]

# 2,3,4
# 리스트명[시작 인덱스:끝 인덱스]
# 시작은 값을 포함한다
# 끝 값을 포함하지 않는다
print(list1[1 : 4])
print(list1)

# 1~4까지 슬라이싱
print(list1[0: 4])
print(list1[: 4])
# 4번부터 마지막 슬라이싱
print(list1[4: 6])
print(list1[4:])

# [1, 2, 3, 4, 5, 6]
# 오른쪽에서 슬라이싱
#  4 5 6
print(list1[-3:])
print(list1[-4:-1])


# 리스트 +
a = [1,2,3]
b = [6,4,5]

# 결과창 지우기 cls
# a리스트에 b를 연결한다.
print(a + b)
# b리스트에 a를 연결한다.
print(b + a)

# 리스트 복사
print(a * 3)

# [1, 2, 3] 2번 삭제
# 파이썬 변수, 리스트 삭제 del
del list1[1]
print(list1)

num = 10
print(num)
del num


c = [10, 3, 90, 25, 33]
# 가장 큰 값
print(max(c))
# 가장 작은 값
print(min(c))

# c 리스트 합계
print(sum(c))

# 정렬 기본적으로 오름차순
print("정렬 전 : ", c)
c.sort()
print("정렬 후 : ", c)

# 내림차순
c.sort(reverse=True)
print("내림차순 : ", c)

# 문자도 정렬가능
nameList = ["z", "a", "h", "b", "f", "l"]
nameList.sort()
print("오름",nameList)
nameList.sort(reverse=True)
print("내림",nameList)

#sorted() 메서드
nameList2 = ["하나", "둘", "셋", "넷"]
nameList3 = ["ㅎ", "ㄹ", "ㄱ", "ㄴ"]

# 비어있는 리스트 생성
# 학생들의 점수를 저장 6개 입력, 출력
# 1번 학생의 점수 : **

scoreList = []

start = 1
while start <= 6 :
    num = int(input(f"{start}번 점수 : "))
    scoreList.append(num)
    start += 1
print("입력받은 리스트 : ", scoreList)

# 입력 받은 점수 중에 85점이 있니?
# 만약 점수가 있다면 몇번째 인덱스에 있는 지 출력
# 만약 점수가 없다면 85 점수는 없습니다 출력
num = 0
list = []
while num < len(scoreList) :
    if scoreList[num] == 85 :
        list.append(num)
        print(num, "번째 인덱스에 85점 존재")
    num += 1

if len(list) == 0 :
    print("85점 없음")


# 강사님 풀이
find = 85
result = find in scoreList
if result :
    # 만약 점수가 있다면 몇번째 인덱스에 있는지 출력
    # index(값) 함수
    index = scoreList.index(find)
    print(index, "번째 있습니다.")
# 만약 점수가 없다면 85점수는 없습니다
else :
    # ValueError index() 함수는 값이 없으면 에러를 낸다
    # try ~ catch 예외 처리
    print(scoreList.index(find))
    print(find, "점수는 없습니다.")
'''

# index(value, start, end)
# value 값 (필수)
# start 검색을 시작할 인덱스 (선택 사항)
# end 검색을 종료할 인덱스 (선택 사항)
# scoreList = [85, 100, 90, 75, 85]
# print("처음 검색 : ", scoreList.index(85))
# print("두번째 검색 : ", scoreList.index(85, 1))

proList = ["python", "spring", "html", "Java", "css", "springboot", "Java"]
print(proList)
print()
proList.reverse()
print("뒤집기 : ", proList)
# 리스트 안에 값의 개수
# 없으면 0을 반환
# print(proList.count("Java"))

# 대소문자 구분함
# print(proList.index("Java"))

# 리스트 삭제
# remove() 리스트에서 원하는 값을 삭제할 때 사용하는 함수
#          특정값이 처음 나오는 위치의 값을 삭제
# proList.remove("Java")
# print(proList)

# pop() 함수
# 특정 인덱스에 해당하는 값을 제거하고
# 그 값을 반환 하는 기능을 가진다.
# 삭제를 하게 되면 뒤에 있는 데이터가 자동으로 앞쪽으로 온다.
# 삭제할 값을 안 넣으면 맨 마지막 데이터 삭제
# print(proList.pop())

# 리스트 안에 데이터만 전부 삭제
# proList.clear()

# del proList


