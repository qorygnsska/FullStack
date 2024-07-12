CREATE TABLE GUESTBOOK (
    IDX NUMBER(*,0) PRIMARY KEY, 
    NAME CHAR(20 BYTE) NOT NULL, 
    PASSWORD CHAR(20 BYTE) NOT NULL, 
    MEMO VARCHAR2(3000 BYTE) NOT NULL, 
    WRITEDATE TIMESTAMP (6) DEFAULT sysdate, 
    IP CHAR(20 BYTE)
);

CREATE SEQUENCE guestbook_idx_seq;


commit;


-- 오라클 developer 프로그램에서
-- 테이블생성 (create), 삭제(drop)
-- 자동으로 commit 된다.

-- 오라클 developer 프로그램에서
-- 데이터를 추가하고 (insert) 삭제(delete)
-- 수정(update) 무조건 commit을 해야한다.

-- 자바에서 보내는 명령문들은 자동으로 커밋된다.
-- 자바에서는 오토커밋이라는 기능이 활성화 되어있기 때문에
-- 자동으로 오라클 데이터베이스에 적용된다.



INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (1, 'User1', 'Pass1', '첵1', SYSTIMESTAMP, '192.168.0.1');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (2, 'User2', 'Pass2', '첵2', SYSTIMESTAMP, '192.168.0.2');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (3, 'User3', 'Pass3', '첵3', SYSTIMESTAMP, '192.168.0.3');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (4, 'User4', 'Pass4', '첵4', SYSTIMESTAMP, '192.168.0.4');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (5, 'User5', 'Pass5', '첵5', SYSTIMESTAMP, '192.168.0.5');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (6, 'User6', 'Pass6', '첵6', SYSTIMESTAMP, '192.168.0.6');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (7, 'User7', 'Pass7', '첵7', SYSTIMESTAMP, '192.168.0.7');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (8, 'User8', 'Pass8', '첵8', SYSTIMESTAMP, '192.168.0.8');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (9, 'User9', 'Pass9', '첵9', SYSTIMESTAMP, '192.168.0.9');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (10, 'User10', 'Pass10', '첵10', SYSTIMESTAMP, '192.168.0.10');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (11, 'User11', 'Pass11', '첵11', SYSTIMESTAMP, '192.168.0.11');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (12, 'User12', 'Pass12', '첵12', SYSTIMESTAMP, '192.168.0.12');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (13, 'User13', 'Pass13', '첵13', SYSTIMESTAMP, '192.168.0.13');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (14, 'User14', 'Pass14', '첵14', SYSTIMESTAMP, '192.168.0.14');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (15, 'User15', 'Pass15', '첵15', SYSTIMESTAMP, '192.168.0.15');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (16, 'User16', 'Pass16', '첵16', SYSTIMESTAMP, '192.168.0.16');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (17, 'User17', 'Pass17', '첵17', SYSTIMESTAMP, '192.168.0.17');
INSERT INTO GUESTBOOK (IDX, NAME, PASSWORD, MEMO, WRITEDATE, IP) VALUES (18, 'User18', 'Pass18', '첵18', SYSTIMESTAMP, '192.168.0.18');