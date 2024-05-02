# 데이터베이스를 꼭! 선택해야된다. 
use db1_book_store;

#Error Code: 1146.
#Table 'db1_book_store.member' doesn't exist
# 해결 방법 : 테이블없으니 테이블 생성하면 됨!

CREATE TABLE member(
	member_no INT,				#회원 고유 번호
	member_id VARCHAR(20),		# 아이디
    member_pw VARCHAR(20),		# 패스워드
    member_name VARCHAR(20),	# 이름
    member_gender VARCHAR(1),	# 성별
    member_point INT,           # 포인트
    member_reg_date DATETIME	# 회원 가입일
);

INSERT INTO member VALUES (1, 'qwer', '1234', '홍길동', 'm',  0, '2021-01-01 12:11:30');
INSERT INTO member VALUES (2, 'java', '1234', '김유신', 'm',  0, '2021-01-02 03:20:54');
INSERT INTO member VALUES (3, 'haha', '1234', '신혜정', 'w', 0, now());
INSERT INTO member VALUES (4, 'tiger', '1234', '선우호랭', 'w', 0, '2020-12-25 05:43:11');
INSERT INTO member VALUES (5, 'green', '1234', '정그린', 'm', 0, '2018-06-12 07:21:08');

select * from member;

# 회원의 번호, 이름 가져오기 
# sql에서 사용하는 키워드(명령어)들은 모두 
# 대문자로 사용하는 것이 규칙!
SELECT 
    member_no,
    member_name
FROM
    member;
    
# 책의 번호,이름, 가격만 조회
SELECT 
    book_no, book_title, book_price
FROM
    book;    # 1. 테이블조회

# 산술연산자 
SELECT 20 + 20 as sum;
SELECT 20 - 20 as dif;

# select 조회를 할 때는 각 행에 접근해서
# 결과를 조회하고 맞으면 가져오고 안 맞으면 안 가져온다.

# 각 도서의 가격을 10% 인상한 금액 출력
# 결과는 책의 제목, 책의 원래 가격, 10% 인상한 결과
SELECT 
    book_title, book_price, book_price * 1.1 AS 인상
FROM
    book;

SELECT 
    *
FROM
    book;
    
# where : 자바에서 if문과 같다!
# select from where 순서
# 비교연산자는 <>(다르다) 말고는 자바와 같다.

# 논리 연산자
# OR
# AND
# NOT

SELECT 
    *
FROM
    member
WHERE
    member_id = 'qwer';
    
    
# book 테이블에서 book_kind가 문학(100)인 정보 가져오기
SELECT 
    *
FROM
    book
WHERE
    book_kind = 100;
    
# book 테이블에서 가격이 15000원 이상인 책 정보 가져오기
SELECT 
    *
FROM
    book
WHERE
    book_price >= 15000;
    
    
# book 테이블에서 book_kind가 문학(100)이 아닌 정보 가져오기
SELECT 
    *
FROM
    book
WHERE
    book_kind <> 100;
    
    
# book 테이블에서 2020년 이전에 등록된 책 정보만 가져오기
SELECT 
    *
FROM
    book
WHERE
    book_reg_date < '2020-01-01';
    
    
# book테이블에서 문학(100) 이거나 컴퓨터(300)인 책의 정보 가져오기
select *
from book
where book_kind = 100 OR book_kind = 300;


#Like(검색 한개 혹은 여러개 검색할때 사용)
# book 테이블에서 책 제목에 java가 포함되어 있는 책 정보 가져오기
SELECT 
    *
FROM
    book
WHERE
    book_title LIKE '%자바%'
        OR book_title LIKE '%java%';
        

# book 테이블에서 책 제목이 '나'로 시작되는 책 정보 가져오기
SELECT 
    *
FROM
    book
WHERE
    book_title LIKE '나%';
    
    
    
# 문제) book테이블에서 외국어로 끝나는 
# 책의 정보를 가져오기 
SELECT 
    *
FROM
    book
WHERE
    book_title LIKE '%외국어';
    
    
    
# 멤버 아이디가 중복 확인
# 가장 간단하게 확인하는 방법은
# count(*)
#  조건에 아이디가 있으면 1을 반환, 아이디가 있다는 것이기 떄문에 자바에서 중복 아이디입니다. 출력
#  0을 반환하면 중복되지 않은 아이디 입니다.
select count(*)
from member
where member_id = 'asdf';


create database memoList;
use memoList;
CREATE TABLE memo (
    memoNo INT,
    memoTitle VARCHAR(100),
    memoContent VARCHAR(300),
    memoDate DATETIME
);

SELECT 
    *
FROM
    memo;

insert into memo values(1, "1등출석", "1등입니다.", '2024-05-02');
insert into memo values(2, "2등출석", "2등입니다.", '2024-05-02');
insert into memo values(3, "3등출석", "3등입니다.", '2024-05-02');
insert into memo values(4, "4등출석", "4등입니다.", '2024-05-02');
insert into memo values(5, "5등출석", "5등입니다.", '2024-05-02');

# 원하는 열의 데이터를 수정하는 명령문
update memo 
set memoContent = '포기해라 난 4등이네', memoTitle = '4등이라 출석'
where memoNo=4;

SELECT 
    *
FROM
    memo;
    

# 삭제
delete from memo
where memoNo = 4;


# 테이블 삭제
drop table memo;

