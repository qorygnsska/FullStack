-- ���̺� ���� 
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
 *   N �� ���� ��� 
 *    �����ڵ� ������ ��� ���� 2byte 
 *    ũ�⸦ ���� �� ������ ����
 * 
 *   N �� ���� ��� 
 *    �ѱ�/���� : 3byte
 *    ����/����/��ȣ : 1byte
 *    ũ�⸦ ����Ʈ �� ������ ���� 
 * 
 *  VAR�� ���� ��� : ���� ����
 *  VAR�� ���� ��� : ���� ����
 * 
 *  ����2�� ���� ��� :  2000byte
 *  ����2�� ���� ��� :  4000byte
 * 
 *  (n) ũ��
 * 
 * 
 *   number( p , s)
 *   P  : ǥ���� �� �ִ� ��ü ���� �ڸ��� (1~38)
 *   S  : �Ҽ��� ���� �ڸ��� 
 * 
 *   
 *  �÷� �ּ� 
 *  comment on column ���̺��.�÷���  is '�ּ�����';
 * 
 * 
 */
comment on column board.name  is '�ۼ���';

/*
 * ���� ���� 
 *  - ���̺� �ۼ��� �� �÷��� ��ϵ� �����Ϳ� ����
 *    ���� ������ ������ ���ִ�.
 *  - �����͸� ���� ���� (���Ἲ) ������ �� �������� ��
 *  - �Է� �����Ϳ� ������ �������� ���� �˻��
 *    �������� ����/���� ���� ���� �˻� ���.. 
 * 
 */
-- ���̺� ���� 
DESC board;

INSERT INTO board (idx, name, password, memo, writedate) VALUES (1, 'ȫ�浿', '1111', '1�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (2, '�Ӳ���', '2222', '2�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (3, '����', '3333', '3�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (4, '������', '4444', '4�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (5, '��ȫ��', '5555', '5�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (6, 'ȫ����', '6666', '6�� �Դϴ�.', SYSDATE);

-- ��ȸ!
select * from board;


-- NOT NULL 
--  �ش� �÷��� �ݵ�� ���� ��ϵǾ�� �ϴ� ��� ���!
--  ���� ������ �÷��� ���� ������ �����ϴ�.
drop table user_notnull;

create table user_notnull(
 	
	user_no   number       not null,
	user_name varchar2(30) not null,
	gender varchar2(10)
);
-- ORA-00947: ���� ���� ������� �ʽ��ϴ�
-- �ذ�: �÷����� �����ϴ�.
insert into user_notnull 
values(1);

insert into user_notnull values(null, null, '��');

-- UNIQUE
--  �÷� �Է� ���� �ߺ��� ���� �ϴ� ���� ��������
--  �÷����� ������ ���ִ�. 
--  ���� ���̺� ���� Ű �� ��ü �Ѵ�.
-- null�� �ߺ��� �����ϴ�.

create table user_unique(

   user_no    number,
   user_name  varchar2(20),
   user_pass  varchar2(30) not null,
   -- �ΰ� �̻��� �÷��� �ߺ�����(����ũ ����)
   -- ��� ǥ���� �� �ִ�.
   unique(user_no, user_name)

);

insert into user_unique
values(1,'������','1111');

-- ORA-00001: ���Ἲ ���� ����(SYSTEM.SYS_C008391)�� ����˴ϴ�
-- �ߺ��Ǵ� �÷� �����ϱ�
insert into user_unique
values(2,'������','2222');


-- check 
--  �ش� �÷��� �Էµǰų� �����Ǵ� ���� üũ�Ͽ�
--  ������ �� �̿��� ���̸� ���� �߻�
--  �� �����ڸ� �̿��Ͽ� ������ �����ϸ� 
--  �� ���� (���ͷ�) ��� �����ϰ� ���ϴ� ���̳�
--   �Լ� ����� �Ұ���

create table user_check(

   user_no    number,
   user_name  varchar2(20) ,
   user_pass  varchar2(30) ,
   gender     varchar2(30) check(gender in ('��','��'))

);

-- ORA-02290: üũ ��������(SYSTEM.SYS_C008392)�� ����Ǿ����ϴ�
-- ������ üũ���� �ٸ���
--insert into user_check values(1, 'user1', 'user2', '����');
insert into user_check values(1, 'user1', 'user2', '��');



-- primary key
--  ���̺��� �� ���� ������ �����ϱ� ���ؼ� ����ϴ�
--  ������ �ĺ�Ű 
--  not null,unique �Ѵ� ������ ������ 
--  ���̺�� �ϳ��� ���� ����
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



-- �ܷ�Ű  foreign key
--  �ٸ� ���̺�� ������ �� ����Ѵ�.
--  ��! primary key�� �̿��ؼ� ���̺�� �����Ѵ�

-- �� ����� �����ϴ� ���̺�
create table user_grade(
	
   grade_code  number   primary key,
   grade_name  varchar2(30) not null

);
			  
INSERT INTO USER_GRADE VALUES(10, '�Ϲ�ȸ��');
INSERT INTO USER_GRADE VALUES(20, '���ȸ��');
INSERT INTO USER_GRADE VALUES(30, 'Ư��ȸ��');

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

insert into user_foregin values(1,'����',10);			  

-- null�� ���� �Ǹ� �θ����̺��� ������ ������
-- ����� ���̺��� ���� ���� �� �� ���ܹ߻��� ���ִ�.
-- ����Ǵ� ���̺��� �⺻Ű�� null ���� �ʵ���
-- ������ �ؾߵȴ�. 
insert into user_foregin values(2,'�ؿ�',null);



-- ����Ŭ 
-- �ڵ����� ���ڸ� �����ϴ� Ű���� ������ (sequence)

/*
 *  create sequence ��������
 *  increment by 1 ( �������� 1�� ���� /�⺻��: 1) 
 *  start with  1  ( �����ϴ� �� /  �⺻��: 1)
 *  minvalue    1  ( �ּҰ�  / �⺻��: 1)
 *  maxvalue   9999 ( �ִ� ��  )
 *  NOCYCLE / cycle (NOCYCLE �ݺ�����)
 * 			        ( cycle ������ �ִ밪�� ���޽� �ٽ� �ּҰ� 1���� ����)
 *  NOCYCLE / cycle (cache ���� �̸� ���ڸ� �Ҵ� �޾Ƽ�
 * 					���ÿ� �����ų� ������ ���ڸ� �ο�)
 */
create sequence board_idx1;

-- ����
create sequence board_idx2
increment by 1
start with 1
minvalue  1
maxvalue 9999
nocycle
nocycle;

-- ���� 

create sequence board_idx3
increment by -1
start with 1000
minvalue  1
maxvalue 1000
nocycle;

-- ������ ����
alter sequence �������� increment by 2;
alter sequence �������� maxvalue 99999;
-- ��! �����ϴ� start with(���� �Ұ�)
-- �� �ܿ��� ��� ���� ����!

-- ���̺� �����ϴ� ��� 
create table board2(

	idx   number primary key,
	str   varchar2(30)

);

insert into board2(idx,str) 
values(board_idx1.nextval,'������1');

insert into board2(idx,str) 
values(board_idx1.nextval,'������2');

insert into board2(idx,str) 
values(board_idx1.nextval,'������3');

select * from board2;

drop table board;

CREATE TABLE board (
    idx       NUMBER(3),
    name      VARCHAR2(100),
    password  VARCHAR2(50),
    memo      VARCHAR2(300),
    writedate date
);

-- ������ ����
drop sequence board_idx1;

create SEQUENCE board_idx1;

INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, 'ȫ�浿', '1111', '1�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '�Ӳ���', '2222', '2�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '����', '3333', '3�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '������', '4444', '4�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, '��ȫ��', '5555', '5�� �Դϴ�.', SYSDATE);
INSERT INTO board (idx, name, password, memo, writedate) VALUES (board_idx1.nextval, 'ȫ����', '6666', '6�� �Դϴ�.', SYSDATE);

select * from board;
delete from board where idx = 9;
commit;