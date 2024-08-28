#파일명: tkinEvent1.py
# 마우스를 클릭했을 때 이벤트!

def 마우스클릭처리함수(event):
    #마우스 클릭시 작동할 내용
    # 윈도우창에 이벤트 설정 
    # bind("마우스클릭종류",이벤트처리함수)
    pass

from tkinter import *
from tkinter import messagebox

def click(event):

    # 딕셔너리
    btnMap = {1:"왼쪽", 2:"가운데", 3:"오른쪽"}

    temp = btnMap.get(event.num)

    # 마우스 이벤트 객체에 마우스 위치를 설정
    msg = f"{temp} 버튼 클릭! 위치 : ({event.x}, {event.y})"

    messagebox.showinfo("마우스", msg)



root = Tk() 
root.geometry("400x400")

# 이벤트 설정
root.bind("<Button-1>",click)
root.bind("<Button-2>",click)
root.bind("<Button-3>",click)

root.mainloop()

'''
def clickLeft(event):
    messagebox.showinfo("마우스","왼쪽 클릭!")

def clickCenter(event):
    messagebox.showinfo("마우스","가운데 클릭!")

def clickRight(event):
    messagebox.showinfo("마우스","오른쪽 클릭!")

# 이벤트 설정
root.bind("<Button-1>",clickLeft)
root.bind("<Button-2>",clickCenter)
root.bind("<Button-3>",clickRight)
'''