# from 파일명 import * (전부)
# from 파일명 import 함수명, 필요한 클래스명

from random import randint

import pymysql as p

# 1. mysql 연결하기 
conn = p.connect(host="localhost", user="root", password="1234", db="pythonTest", charset="utf8")

# 2. 데이터베이스 조작 cursor()
cur = conn.cursor()

# select일 경우에는 저장할 필요 X
cur.execute(''' 
    select * from userTable
''')

# fetchall()
# sql에서 조회된 모든 내용을 가져오는 메서드
print("아이디 이름 이메일 생년월일")
for row in cur.fetchall() :
    # print(row) # 튜플 자료형
    print(f"{row[0]} | {row[1]} | {row[2]}")

conn.close()

# 오라클 디비 연결
# pip install oracledb
# import oracledb
# user, password, dsn(Database Source Name)
# dsn = "호스트이름:port/데이터베이스명"
# user = "system" password = "1234"
# dsn = "localhost:1521/xe"