CREATE TABLE book (
    name  VARCHAR2(100),
    price NUMBER(6)
);

CREATE TABLE "numList" (
    no  NUMBER(2),
    str VARCHAR2(100)
);

select * from numList;

insert into "numList" values(1, '1');
insert into "numList" values(2, '2');
insert into "numList" values(3, '3');

select * from "numList";


insert all 
into "numList" values(4, '4')
into "numList" values(5, '5')
into "numList" values(6, '6')
select * from dual;

select * from "numList";