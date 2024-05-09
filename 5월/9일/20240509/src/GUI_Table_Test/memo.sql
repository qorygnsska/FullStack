create database tableMemo;

use tableMemo;

create table memo(
	num int primary key auto_increment, 
    title varchar(100),
    writer varchar(100),
    content varchar(300),
    readCount int
);