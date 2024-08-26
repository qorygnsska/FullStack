ice = {
    '메로나' : 1000,
    '폴라포' : 1200,
    '빵빠레' : 1800,
}

################################

ice['죠스바'] = 1200
ice['월드콘'] = 1500
print(ice)

################################

print(f"메로나 가격 : {ice['메로나']}")

################################

ice['메로나'] = 1300
print(ice)

################################

del ice['메로나']
print(ice)

################################

# 누가바가 없어서


#파일명: dictEx2.py

# 91문
inventory = {
    "메로나" : [300,20],
    "비비빅" : [400,3],
    "죠스바" : [250,100]
}
print(inventory)

# 메로나 가격
print(inventory["메로나"][0] ,'원')

# 메로나 재고
print(inventory["메로나"][1] ,'개')

inventory['월드콘'] = [500,7]
print(inventory)

icecream = {'탱크보이': 1200, 
            '폴라포': 1200, 
            '빵빠레': 1800, 
            '월드콘': 1500,
            '메로나': 1000}

# keys() 메서드 이용
keys = list(icecream.keys())
print(keys)

# values() 메서드 이용
values = list(icecream.values())
print(values)

# 아이스크림 총합 
print(sum(icecream.values()),"원",sep='')

new_product = {'팥빙수': 2700, '아맛나': 1000}

icecream.update(new_product)
print(icecream)

# 평균 합계
def print_score(scores):
    avg = sum(scores) / len(scores)
    print(avg)

print_score([1,2,3])

# 역순으로 문자 출력
def print_reverse(string):
    print(string[::-1]) # 전체 문자를 거꾸로 이동
    # 문자[start:stop:step]
    # :step 생략시 기본적으로 1 

print_reverse("python")