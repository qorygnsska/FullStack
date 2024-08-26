
# # 자바에서 Map 형식!
# # key-value 이용해서 데이터를 저장하는 구조
# # 파이썬에서 딕셔너리
# # {key : value}
# # 자료형 dict 키워드로 있음
# dict1 = {'python' : 90, 'java' : 80}
# print(dict1)

# dict2 = {
#     'name' : '이서희',
#     'age' : 20,
#     'job' : '강사'
# }
# # 전체 출력
# print(dict2)

# # 부분적으로 출력
# # 이름
# print(dict2['name'])
# print(dict2['job'])

# # 프로그래밍 수업 참여도!
# # python '상' c# '하' c++ '중'

# # 추가(딕녀서리는 따로 함수가 필요없음)
# # 변수명[key] = value
# # value에는 모든 타입을 다 저장할 수 있다
# dict2['pro'] = {
#     'python' : '상',
#     'c#' : '하',
#     'c++' : '중'
# }

# print(dict2['pro']['python'])

# dict2['phone'] = "010-1234-1234"
# print(dict2)

dict3 = {}
dict3[1] = [1, 2, 3]
print(dict3)
print(dict3[1][1])

dict3[10] = "이서희"
print(dict3[10])
# 딕셔너리는 따로 추가하거나 수정하는것이 똑같다.
# key를 작성해서 실행을 하면 만약 key
# 딕셔너리 변수에 있다면 값을 수정!
# key 없으면 새로운 객체를 생성
dict3[10] = (1, 2, 3, 4)
print(dict3[10])
del dict3[10]
print(dict3)

# del dict3
# print(dict3)

# key 중복적이면 안된다. (고유한 키)
# 문자, 숫자, 튜플 나머지는 안됨!

# value 중복적인 값 저장 가능!

# 딕셔너리 key만 꺼내고 싶을 경우
seohee = {'name' : 'seohee', 'age' : 20, 'gender' : 'f'}
# 사용하고 싶을 경우에는 형변환 list()
print(seohee.keys())
print(seohee.values())

# 딕셔너리는 반복을 돌리면 key가 반환
# items() : 모든 키와 값을 쌍으로 가져오기
for key, value in seohee.items() :
    # print(seohee[x])
    print(f"{key} : {value}")

addInfo = {'hei' : 160.21, 'wei' : 60}

seohee.update(addInfo)
print(seohee)

# seohee 길이 구하기
print("seohee", len(seohee))

# name key가 seohee 변수안에 있니?
# 딕셔너리는 in 연산자를 사용할 때 key 값 기준으로 검색
print('name' in seohee)

# value 기준으로 검색
print('seohee' in seohee.values())

# 내가 삭제할 값을 반환해서 출력
# 딕셔너리 pop('key')
age = seohee.pop('age')
print("삭제한 나이 : ", age)

# 안에 있는 데이터를 모두 삭제!
seohee.clear()

list1 = [i for i in range(1, 6)]
print(list1)

dict5 = {i : i**2 for i in range(1, 6)}
print(dict5)

