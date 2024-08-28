
# 여러개 모듈을 포함하면 중복되는 함수들 클래스 이름이 올 수 있다
# import 모듈명 as 별명
# 데이터베이스명 tkinterEx
# 테이블 id, pw mysql 연결
from tkinter import *

def msg() :
    # 엔트리에서 값을 꺼내기
    # 아이디 비밀번호
    idNow = entry.get()
    pwNow = entry2.get()

    if idNow == 'love' and pwNow == 'love' :
        print("로그인 성공")
    else :
        print("로그인 실패")

root = Tk()
root.geometry("500x200") 

label = Label(root, text="아이디")
label.pack()
entry = Entry(root, width=30)
entry.pack(pady=5)

label2 = Label(root, text="비번")
label2.pack()
entry2 = Entry(root, width=30)
entry2.pack(pady=5)

btn = Button(root, text="확인", command=msg)
btn.pack()




root.mainloop()


'''
# input > entry
# 사용자로부터 입력을 받는 컴포넌트
entry = Entry(root, width=30)
entry.pack(pady=5)
'''