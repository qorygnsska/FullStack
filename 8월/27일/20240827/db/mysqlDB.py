
# user : root
# password : 1234
# host : localhost / 3306

# 1. 데이터베이스 mysql에서 생성
# 2. 파이썬 mysql이 호환될 수 있도록 라이브러리 다운
# pip install pymysql

# 파이썬에서 제공하는 sql
# 기본 내장형 sqlite3
# 라이브러리를 다운로드 x
# import sqlite3 as s

import pymysql

# 1. mysql 연결하기 
conn = pymysql.connect(host="localhost", user="root", password="1234", db="pythonTest", charset="utf8")
# print(conn)

# 2. 데이터베이스 조작 cursor()
cur = conn.cursor()

# 3. 테이블 생성 
cur.execute(''' 
    create table userTable(
        id varchar(4),
        userName varchar(15), 
        email varchar(50),
        birthYear int
    )
''')

# 4. 데이터 저장(입력하기)
cur.execute("INSERT INTO userTable VALUES('iu', '아이유', 'iu@kpop.com', 1993)") 
cur.execute("INSERT INTO userTable VALUES('bts', '방탄소년단', 'bts@bighit.com', 2013)") 
cur.execute("INSERT INTO userTable VALUES('psy', '싸이', 'psy@yg.com', 1977)") 
cur.execute("INSERT INTO userTable VALUES('boa', '보아', 'boa@sm.com', 1986)")

# 5. 위에 실행문을 실행하고 나서 commit() 저장
conn.commit()

# 6. 닫기 close()
conn.close()