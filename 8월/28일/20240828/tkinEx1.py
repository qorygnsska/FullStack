#폴더명: 20240828
#파일명: tkinEx1.py

# tkinter GUI프로그래밍 
# 파일명: tkinter.py 파일명을 똑같이 하면 
# 충돌이 발생할 수 있다. 

from tkinter import *

#Tk() 기본적으로 윈도우창을 반환한다.
# 제일 아래에 깔리는 윈도우창 
root = Tk() 

# 이 부분에서 컴포넌트들을 배치
root.title(" 처음 만든 윈도우")  # 제목
root.geometry("500x200")       # 창 크기
root.resizable(width=FALSE,height=FALSE) # 자동조절

root.mainloop()