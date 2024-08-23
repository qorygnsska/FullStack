'''
# 문자열 내에 어떤 값을 삽입하거나
# 형식에 맞춰서 사용될 때 
# 문자열 포멧팅

# format 함수
# {} 값을 지정할 수 있다. 2.6버전 이상

# f문자열 포맷
# {} 중괄호 안에 변수나 간단한 표현식
# 3.6버전 이상!

# 숫자 대입
text = "{}번 고객님 환영합니다!"\
        .format(1)
print(text)

# 문자는 곱하기를 했을 때 복사!
print("=" * 20)

name = input("이름 : ")
text2 = "{}, 안녕하세요!".format(name)
print(text2)

print("=" * 20)

# 2개 이상 값 대입
text3 = "{}년 {}월 {}일".format(2024, 8, 23)
print(text3)

print("=" * 20)

# 변수를 이용해서 값을 대입
text4 = "이름 : {name2}, 나이 : {age}".format(name2 = "이익준", age = 30)
print(text4)

print("=" * 20)

# 인덱스를 이용해서 대입 변수명과 혼용
text5 = "{0}은 {1}보다 {2}가 낮다 하지만 {name3}".format("수성", "태양", "온도", name3="지구")
print(text5)

print("=" * 20)
'''

# 정렬 < 왼쪽 정렬
# 10칸 중에서 format 문자를 왼쪽으로 정렬
text6 = "{:<10}".format("안녕")
# 문자열 문자열은 더하기를 하면 콤마 공백 없이 사용 가능하다
print(text6 + "하세요!")

# 정렬 > 오른쪽 정렬
# 10칸 중에서 format 문자를 오른쪽으로 정렬
text7 = "{:>10}".format("안녕")
# 문자열 문자열은 더하기를 하면 콤마 공백 없이 사용 가능하다
print(text7 + "하세요!")

# 정렬 ^ 가운데 정렬
# 10칸 중에서 format 문자를 가운데로 정렬
text8 = "{:^10}".format("안녕")
print(text8 + "하세요!")

# 공백 채우기
# 특정 문자로 공백을 채울 수 있다.
text9 = "{:*^10}".format("안녕")
print(text9 + "하세요!")

# 소수점 표현하기
number = 3.141592
text10 = "{:.2f}".format(number)
print(text10)

# {html}과 {CSS}의 차이
# 중괄호를 문자로 표현하고 싶을 때
text11 = "{{{0}}}과 {{{1}}}의 차이".format("html", "CSS")
print(text11)