# mysql은 데이터베이스를 선택!
use personlist;

# 테이블 조회(확인)
select * from employee;
select * from student;

# 안에 있는 내용을 삭제 delete;
# 테이블 자체를 삭제하고 싶으면 drop

# 어떤 조건에 의해서 삭제를 할 때는 where 삭제
DELETE FROM student 
WHERE
    age >= 15;

# 특정 한명만 삭제
DELETE FROM student 
WHERE
    hakbun = 1000;

# insert를 사용해 데이터를 전체가 아닌 일부만 넣고싶다면
# 테이블명(필드명, 필드명) 을 작성해 매치를 시켜줘야한다.

-- 제약조건
-- Not Null
# 데이터가 null이 들어오면 안될 때 제약조건을 설정할 수 있는데
# not null 제약조건을 설정하면 null 값을 넣을 수 없다.

-- Primary Key
# primary key 제약조건은 테이블에서 유일하게 하나의 필드만 설정할 수 있다.
# primary key를 사용하면 중복된 값을 넣을 수 없다.


# 이미 만들어져 있는 테이블에 필드명이나 설정을 수정할 때나
# 새롭게 추가할 때는 키워드 alter

# auto_increment를 사용하려면 고유한 key가 테이블에 설정되어 있어야함.
alter table employee
add column empno int auto_increment primary key,
auto_increment = 100;

# 이미 테이블에서 만들어진 필드를 삭제할 때는
alter table employee
drop column empno;

