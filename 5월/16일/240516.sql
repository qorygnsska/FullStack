-- 테이블 생성 
CREATE TABLE board (
    idx       NUMBER(3),
    name      VARCHAR2(100),
    password  VARCHAR2(50),
    memo      VARCHAR2(300),
    writedate date
);

/*
 *   NVARCHAR2
 * 
 *   N 이 있을 경우 
 *    유니코드 문자형 모든 문자 2byte 
 *    크기를 글자 수 단위로 받음
 * 
 *   N 이 없을 경우 
 *    한글/한자 : 3byte
 *    영어/숫자/기호 : 1byte
 *    크기를 바이트 수 단위로 받음 
 * 
 *  VAR가 있을 경우 : 가변 문자
 *  VAR가 없을 경우 : 고정 문자
 * 
 *  숫자2가 없을 경우 :  2000byte
 *  숫자2가 있을 경우 :  4000byte
 * 
 *  (n) 크기
 * 
 * 
 *   number( p , s)
 *   P  : 표현할 수 있는 전체 숫자 자리수 (1~38)
 *   S  : 소수점 이하 자리수 
 * 
 *   
 *  컬럼 주석 
 *  comment on column 테이블명.컬럼명  is '주석내용';
 * 
 * 
 */
comment on column board.name  is '작성자';

/*
 * 제약 조건 
 *  - 테이블 작성시 각 컬럼에 기록될 데이터에 대해
 *    제약 조건을 설정할 수있다.
 *  - 데이터를 오류 없이 (무결성) 보장을 주 목적으로 함
 *  - 입력 데이터에 문제가 없는지에 대한 검사와
 *    데이터의 수정/삭제 가능 여부 검사 등등.. 
 * 
 */
-- 테이블 구조 
DESC board;

INSERT INTO board (idx, name, password, memo, writedate) VALUES (1, '홍길동', '1111', '1등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (2, '임꺽정', '2222', '2등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (3, '장길산', '3333', '3등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (4, '일지매', '4444', '4등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (5, '길홍동', '5555', '5등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (6, '홍동길', '6666', '6등 입니다.', SYSDATE);

-- 조회!
select * from board;


-- NOT NULL 
--  해당 컬럼에 반드시 값이 기록되어야 하는 경우 사용!
--  제약 조건은 컬럼명 마다 설정이 가능하다.
drop table user_notnull;

create table user_notnull(
 	
	user_no   number       not null,
	user_name varchar2(30) not null,
	gender varchar2(10)
);
-- ORA-00947: 값의 수가 충분하지 않습니다
-- 해결: 컬럼값이 부족하다.
insert into user_notnull 
values(1);

insert into user_notnull values(null, null, '남');

-- UNIQUE
--  컬럼 입력 값에 중복을 제한 하는 제약 조건으로
--  컬럼명마다 설정할 수있다. 
--  만약 테이블에 기준 키 를 대체 한다.
-- null값 중복은 가능하다.

create table user_unique(

   user_no    number,
   user_name  varchar2(20),
   user_pass  varchar2(30) not null,
   -- 두개 이상의 컬럼에 중복제거(유니크 설정)
   -- 묶어서 표현할 수 있다.
   unique(user_no, user_name)

);

insert into user_unique
values(1,'이익준','1111');

-- ORA-00001: 무결성 제약 조건(SYSTEM.SYS_C008391)에 위배됩니다
-- 중복되는 컬럼 제거하기
insert into user_unique
values(2,'이익쥰','2222');


-- check 
--  해당 컬럼에 입력되거나 수정되는 값을 체크하여
--  설정된 값 이외의 값이면 에러 발생
--  비교 연산자를 이용하여 조건을 설정하며 
--  비교 값을 (리터럴) 사용 가능하고 변하는 값이나
--   함수 사용은 불가능

create table user_check(

   user_no    number,
   user_name  varchar2(20) ,
   user_pass  varchar2(30) ,
   gender     varchar2(30) check(gender in ('남','여'))

);

-- ORA-02290: 체크 제약조건(SYSTEM.SYS_C008392)이 위배되었습니다
-- 설정한 체크값이 다르다
--insert into user_check values(1, 'user1', 'user2', '남자');
insert into user_check values(1, 'user1', 'user2', '남');



-- primary key
--  테이블에서 한 행의 정보를 구분하기 위해서 사용하는
--  고유한 식별키 
--  not null,unique 둘다 가지고 있으며 
--  테이블당 하나만 설정 가능
create table user_info(
    user_no number primary key,
    user_name varchar2(30),
    user_age number check(user_age >= 20)
);
create table user_info(

	user_no     number  ,
	user_name   varchar2(30),
	user_age    number check(user_age >= 20),
	primary key(user_no)
);

insert into user_info values(1 ,'dd',19);



-- 외래키  foreign key
--  다른 테이블과 연결할 때 사용한다.
--  단! primary key를 이용해서 테이블과 연결한다

-- 고객 등급을 저장하는 테이블
create table user_grade(
	
   grade_code  number   primary key,
   grade_name  varchar2(30) not null

);
			  
INSERT INTO USER_GRADE VALUES(10, '일반회원');
INSERT INTO USER_GRADE VALUES(20, '우수회원');
INSERT INTO USER_GRADE VALUES(30, '특별회원');

create table user_foregin(

	user_no     number  primary key,
	user_name   varchar2(30) not null,
	grade_code  number 	REFERENCES user_grade(grade_code)
	
);			  
			  
create table user_foregin2(

	user_no     number  primary key,
	user_name   varchar2(30) not null,
	grade_code  number ,
	foreign key (grade_code) REFERENCES user_grade(grade_code)
);

insert into user_foregin values(1,'익준',10);			  

-- null이 들어가게 되면 부모테이블에서 데이터 삭제시
-- 연결된 테이블을 같이 삭제 할 때 예외발생할 수있다.
-- 연결되는 테이블의 기본키가 null 들어가지 않도록
-- 설정을 해야된다. 
insert into user_foregin values(2,'준완',null);



-- 오라클 
-- 자동으로 숫자를 증가하는 키워드 시퀀스 (sequence)

/*
 *  create sequence 시퀀스명
 *  increment by 1 ( 증가값이 1씩 증가 /기본값: 1) 
 *  start with  1  ( 시작하는 값 /  기본값: 1)
 *  minvalue    1  ( 최소값  / 기본값: 1)
 *  maxvalue   9999 ( 최대 값  )
 *  NOCYCLE / cycle (NOCYCLE 반복안함)
 * 			        ( cycle 시퀀스 최대값에 도달시 다시 최소값 1부터 시작)
 *  NOCYCLE / cycle (cache 여부 미리 숫자를 할당 받아서
 * 					동시에 들어오거나 빠르게 숫자를 부여)
 */
create sequence board_idx1;

-- 증가
create sequence board_idx2
increment by 1
start with 1
minvalue  1
maxvalue 9999
nocycle
nocycle;

-- 감소 

create sequence board_idx3
increment by -1
start with 1000
minvalue  1
maxvalue 1000
nocycle;

-- 시퀀스 수정
alter sequence 시퀀스명 increment by 2;
alter sequence 시퀀스명 maxvalue 99999;
-- 단! 시작하는 start with(변경 불가)
-- 그 외에는 모두 변경 가능!

-- 테이블에 적용하는 방법 
create table board2(

	idx   number primary key,
	str   varchar2(30)

);

insert into board2(idx,str) 
values(board_idx1.nextval,'시퀀스1');

insert into board2(idx,str) 
values(board_idx1.nextval,'시퀀스2');

insert into board2(idx,str) 
values(board_idx1.nextval,'시퀀스3');

select * from board2;

drop table board;

CREATE TABLE board (
    idx       NUMBER(3),
    name      VARCHAR2(100),
    password  VARCHAR2(50),
    memo      VARCHAR2(300),
    writedate date
);

-- 시퀀스 삭제
drop sequence board_idx1;

create SEQUENCE board_idx1;

INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '홍길동', '1111', '1등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '임꺽정', '2222', '2등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '장길산', '3333', '3등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '일지매', '4444', '4등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '길홍동', '5555', '5등 입니다.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '홍동길', '6666', '6등 입니다.', SYSDATE);

select * from board;
delete from board where idx = 9;
commit;