
from A import show, AA
show()
print()

AA()

# 여러개의 파일들이 import
# 중복되는 메서드나 클래스명 변수명이 충돌!
# print(var)
# print(string)








# # A.py 파일을 포함을 해서 그 안에 있는 내용 출력, 메서드 실행

# # 모듈
# # - 함수, 클래스, 변수 정의하는 파일
# # - 다른 파이썬 파일에서 가져가서 사용할 수 있도록 정리해놓은 파일

# # 여러개의 파이썬 파일에서 공통적인 내용을 사용할 때 중보적으로 명령문을
# # 작성하지 않고 미리 만들어놓은 파일을 이용하면 좋다!

# # 파일명만 import에 작성하면 된다.
# # import A
# # print(A.var)
# # print(A.string)

# # # 함수 실행
# # A.show()

# # a1 = A.AA()


# # 파일을 찾을 때
# # 1. B.py 폴더 안에서 먼저 파일을 찾는다
# #    파일이 없으면 예외
# # 2. python이 설치되어 있는 폴더 전체를 찾는다

# # 파이썬 실행해서 지정한 경로를 포함
# import sys
# # print(sys.path)

# # 경로 추가
# # 내가 포함하는 경로에 가서 절대경로!
# sys.path.append("C:\\fullstack")
# print(sys.path)

# # c드라이브안에 fullstack안에 test파일
# import test

# test.show()
# print(test.s)