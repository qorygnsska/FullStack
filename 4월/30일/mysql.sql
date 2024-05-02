# 테이블(표 형식) 저장하는 공간을 만든다.
# 클래스처럼 어떤 데이터를 저장하기 위해서 틀을 제공한다

create table memberList(
	# 실제 저장할 컬럼명
    id varchar(30),
    pw varchar(30)

);

# 데이터베이스는 대소문자 구별 안함!
# 실제 값을 저장해야된다.
insert into memberList values("qwer", "qwer");

# 여러개의 값을 한꺼번에 저장하고 싶으면
insert into memberlist values
("asdf", "asdf"),
("zxcv", "zxcv"),
("abcd", "abcd");

# 추가한 데이터 확인
select * from memberlist;