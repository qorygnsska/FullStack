-- 테이블을 생성할 때 자동으로 순번 주는 내용은
-- 안 해도됨! 
-- create , drop   자동 commit;
-- insert , update, delete 자동 commit X

drop table Movie;

create table Movie(
	
	rnum    	   varchar2(30),
	rank           varchar2(30),
	rankOldAndNew  varchar2(50),
	movieNm        varchar2(100),
	openDt         varchar2(50),
	audiAcc        varchar2(50)	
);

-- 이미 만들어진 컬럼을 삭제하기 위해서는 
-- alter table 명  drop column 명;
alter table movie drop column boxofficeType;

-- ORA-12899: KH.테이블명.컬럴명 
--          열에 대한 값이 너무 큼! 
--  내가 컬럼을 설정할 때 바이트 수 가 작아서 생긴 에러!
--  제일 쉬운 방법은 테이블을 삭제하고 해당 컬럼의
--  크기를 증가한 후 다시 테이블 생성하면 된다.

create table muser(
    id VARCHAR2(50) ,
    name VARCHAR2(100) ,
    password VARCHAR2(100) ,
    phone_number VARCHAR2(20),
    email VARCHAR2(100),
    birth_date varchar2(100)
);

insert into muser values("qwer"
			,"익준","1234","010-1234-1234",
			"emp@g.c","1999-01-01");
			
CREATE TABLE Ticket (
    ticket_id NUMBER PRIMARY KEY,
    user_id VARCHAR2(50),
    movie_title VARCHAR2(100),
    movie_date VARCHAR2(100),
   	count NUMBER,
    seat VARCHAR2(20)
);
-- 오라클에서 자동으로 티켓구매한 순서를 저장하는
-- 시퀀스를 작성해 보세요~
	
create sequence seq_ticket;
-- ORA-01031: 권한이 불충분합니다			
-- system으로 접속해서 권한 주기 			

grant create sequence to KH;


commit;

alter table muser
add primary key (id);

-- Join
--  각각의 테이블을 연결해서 하나의 결과를 가져오는
--  것! 

-- 제약조건 
-- 외래키 설정  foreign key 설정 
-- 이미 만들어져있으니 추가하는 alter 

alter table Ticket 
add foreign key (user_id)
references muser(id);


-- join 할때 기준이 되는 테이블을 from에서 
-- 작성하고 그리고 join을 하면 된다.
select 
	-- 원하는 내용만 뽑아도 되고 u.name,t.movie_title
	*
from ticket t
join muser u on t.user_id = u.id;
/**
 * 외래키 (테이블을 연결하는 키들은) 기본키가 
 * 있어야된다. 
 * 
 *  
 * 
 * select
 *    컬럼명 혹은    *
 * 
 * from  기준이 되는 테이블
 * join  연결할 테이블명 on 조건 ;
 * 
 */