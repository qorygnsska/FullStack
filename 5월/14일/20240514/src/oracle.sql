-- 오라클은 계정 단위로 테이플(표) 형식으로 관리한다
-- system 계정이 각각의 user의 권한을 준다.
-- 11g -> 21c
-- system(기본계정명) 대소문자 안가림
-- 1234 (비밀번호) 대소문자 구별
-- 12c 버전 이상부터는 부조건 계정을 생성할 때 c## 붙인다. -> c##계정명 or C##계정명
-- 단 alter session set "_ORACLE_SCRIPT"=true; 적용하면 c## 안 써도 됨

-- 오라클 사용자 계정 만들기
-- create user 유저명 identified by 비밀번호;

-- 오라클 사용자 계정을 만들었다면 오라클을 사용할 수 있는 권한(grant) 
-- connect (기본적인 DB접속 권한) 
-- dba (모든 시스템 권한) 
-- resource (자바의 프로그래밍처럼 제어문사용,함수)
-- grant connect, resource , dba to KH;

-- 권한 해제 (revoke)
-- revoke connect, resource , dba from KH;

-- 12c 버전 이상의 계정을 생성할 때 세션을 변경하는 alter코드를 실행하지 않으면 아래처럼 계정을 실행해야된다.

create user c##scott identified by 1234;
-- 권한
grant connect, resource, dba to c##scott;

-- 영구적으로 저장한다.
commit;

-- 전체 유저 이름을 확인할 수 있는 명령문
select username from all_users;
select username from dba_users;

-- 잠긴 계정을 풀기
alter user [username] account unlock;

-- Database
-- 정의
-- 공용 데이터 : 공동으로 사용되는 데이터
-- 통합 데이터 : 중복 최소화로 중복으로 인한 데이터 불일치 현상을 제거
-- 저장 데이터 : 컴퓨터 저장 장치에 저장된 데이터
-- 운영 데이터 : 조직의 목적을 위해서 사용되는 데이터

-- 특징 
-- 실시간 접근성 : 사용자가 데이터 요청시 실시간으로 결과 서비스
-- 계속적인 변화 : 데이터 값은 시간에 따라 항상 바뀜
-- 동시 공유 : 서로 다른 업무 또는 여러 사용자에게 공유 된다.
-- 사용자가 요구하는 데이터 내용으로 데이터를 찾아서 보내줌

-- 데이터 추출 , 조작 , 정의, 제어 등을 할 수 있게 
-- 해주는 데이터베이스 전용 관리 프로그램 (DBMS)

-- DDL (데이터 정의어)
--  데이터(테이블 구조를 정의하고 삭제 및 변경)
--  create, alter, delete
--  자동 commit;

-- DML (데이터 조작어)
-- 사용자가 저장된 데이터를 실질적으로 처리하는데 사용
--  select, insert , delete, update 
--  자동 commit이 안된다. 

-- DCL(데이터 제어어)
--  데이터의 보안, 무결성 , 저장, 초기화하는 등 
-- commit, rollback ,grant

-- 자동 정렬 Ctrl + f7

-- sql은 테이블이름에 대소문자 구분을 하지 않는다
-- 오라클에서 대소문자를 구별하고 싶다면 테이블명에 ""를 써주면 된다.
-- 단 검색할 때도 "" 써야함!!
select * from "numList";

-- 데이터 추가하는 insert into 문
-- 오라클은 문자를 입력할 때 ' '
insert into "numList" values(1, '1');

-- 한번에 여러개의 insert into를 할 수 있다. , 안써도 됨!!
-- select * from dual (가상 테이블)
-- 실제 값이 없기 때문에 현재 추가하는 내용만 테이블에 추가하고 반환되는 행은 무시한다.
insert all 
into "numList" values(4, '4')
into "numList" values(5, '5')
into "numList" values(6, '6')
select * from dual;

-- 자바와 오라클이랑 연결하는 커넥터가 필요하다
-- ojdbc.jar
