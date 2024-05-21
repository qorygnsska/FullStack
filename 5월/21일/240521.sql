-- ���̺��� ������ �� �ڵ����� ���� �ִ� ������
-- �� �ص���! 
-- create , drop   �ڵ� commit;
-- insert , update, delete �ڵ� commit X

drop table Movie;

create table Movie(
	
	rnum    	   varchar2(30),
	rank           varchar2(30),
	rankOldAndNew  varchar2(50),
	movieNm        varchar2(100),
	openDt         varchar2(50),
	audiAcc        varchar2(50)	
);

-- �̹� ������� �÷��� �����ϱ� ���ؼ��� 
-- alter table ��  drop column ��;
alter table movie drop column boxofficeType;

-- ORA-12899: KH.���̺��.�÷��� 
--          ���� ���� ���� �ʹ� ŭ! 
--  ���� �÷��� ������ �� ����Ʈ �� �� �۾Ƽ� ���� ����!
--  ���� ���� ����� ���̺��� �����ϰ� �ش� �÷���
--  ũ�⸦ ������ �� �ٽ� ���̺� �����ϸ� �ȴ�.

create table muser(
    id VARCHAR2(50) ,
    name VARCHAR2(100) ,
    password VARCHAR2(100) ,
    phone_number VARCHAR2(20),
    email VARCHAR2(100),
    birth_date varchar2(100)
);

insert into muser values("qwer"
			,"����","1234","010-1234-1234",
			"emp@g.c","1999-01-01");
			
CREATE TABLE Ticket (
    ticket_id NUMBER PRIMARY KEY,
    user_id VARCHAR2(50),
    movie_title VARCHAR2(100),
    movie_date VARCHAR2(100),
   	count NUMBER,
    seat VARCHAR2(20)
);
-- ����Ŭ���� �ڵ����� Ƽ�ϱ����� ������ �����ϴ�
-- �������� �ۼ��� ������~
	
create sequence seq_ticket;
-- ORA-01031: ������ ������մϴ�			
-- system���� �����ؼ� ���� �ֱ� 			

grant create sequence to KH;


commit;

alter table muser
add primary key (id);

-- Join
--  ������ ���̺��� �����ؼ� �ϳ��� ����� ��������
--  ��! 

-- �������� 
-- �ܷ�Ű ����  foreign key ���� 
-- �̹� ������������� �߰��ϴ� alter 

alter table Ticket 
add foreign key (user_id)
references muser(id);


-- join �Ҷ� ������ �Ǵ� ���̺��� from���� 
-- �ۼ��ϰ� �׸��� join�� �ϸ� �ȴ�.
select 
	-- ���ϴ� ���븸 �̾Ƶ� �ǰ� u.name,t.movie_title
	*
from ticket t
join muser u on t.user_id = u.id;
/**
 * �ܷ�Ű (���̺��� �����ϴ� Ű����) �⺻Ű�� 
 * �־�ߵȴ�. 
 * 
 *  
 * 
 * select
 *    �÷��� Ȥ��    *
 * 
 * from  ������ �Ǵ� ���̺�
 * join  ������ ���̺�� on ���� ;
 * 
 */