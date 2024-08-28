
from tkinter import *

win = Tk()

# 라벨
# 문자를 표현할 수 있는 컨트롤을 의미함
# Label(어디윈도우, 옵션...)
label1 = Label(win, text="python")

# 배치 윈도우 창에 추가
label1.pack()

label2 = Label(win, text="python2", font=("궁서체", 30, "bold"), fg="red")
label2.pack()

label3 = Label(win, text="python3", font=("궁서체", 30), bg="blue", width=20, height=5)
label3.pack()

# pack()
# 한줄에 하나씩 가운데 정렬
# 엑스버튼을 클릭할 때까지 계속 반복
win.mainloop()