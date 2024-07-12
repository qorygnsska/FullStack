DROP TABLE MVCBOARD;

CREATE TABLE MVCBOARD (
    IDX NUMBER(10, 0) NOT NULL, 
    NAME VARCHAR2(20 BYTE) NOT NULL, 
    SUBJECT VARCHAR2(200 BYTE) NOT NULL, 
    CONTENT VARCHAR2(3000 BYTE) NOT NULL, 
    GUP NUMBER(10, 0), 
    LEV NUMBER(10, 0), 
    SEQ NUMBER(10, 0), 
    HIT NUMBER(10, 0) DEFAULT 0, 
    WRITEDATE TIMESTAMP (6) DEFAULT SYSDATE, 
    CONSTRAINT MVCBOARD_PK PRIMARY KEY (IDX)
);

CREATE SEQUENCE MVCBOARD_SEQ;

INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '방탄소년단 진', '새 앨범 발매', '우리의 새 앨범이 나왔어요!', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '아이유', '콘서트 공지', '다음 콘서트에 와주세요!', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '박서준', '영화 시사회', '제 새 영화가 개봉합니다!', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '송혜교', '드라마 시리즈', '새 드라마 시리즈가 방영됩니다!', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '공유', '광고 촬영', '새 광고 촬영을 했어요.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '전지현', '팬미팅 공지', '팬미팅 날짜가 정해졌어요!', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '이민호', '팬들과의 소통', '팬들과 소통하는 시간을 가졌어요.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '김수현', '새 드라마', '새 드라마가 곧 시작됩니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '손예진', '영화 촬영', '새 영화 촬영 중입니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '이종석', '화보 촬영', '멋진 화보 촬영을 했어요.', 1, 1, 1, 0, SYSDATE);

INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '박보검', '팬과의 만남', '팬과의 만남을 가졌어요.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '한지민', '드라마 촬영', '드라마 촬영 중입니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '현빈', '영화 개봉', '새 영화가 개봉했습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '이준기', '화보 공개', '새로운 화보가 공개되었습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '박신혜', '팬들과의 만남', '팬들과의 즐거운 시간을 가졌습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '정해인', '드라마 출연', '새 드라마에 출연하게 되었습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '김태리', '영화 촬영', '영화 촬영이 한창입니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '조정석', '뮤지컬 공연', '새 뮤지컬 공연이 시작됩니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '류준열', '영화 개봉', '영화가 드디어 개봉합니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '수지', '콘서트 투어', '새로운 콘서트 투어가 시작됩니다.', 1, 1, 1, 0, SYSDATE);

INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '박보영', '팬미팅 일정', '팬미팅 일정이 확정되었습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '송중기', '영화 촬영 소식', '영화 촬영 중입니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '김지원', '드라마 주연', '새 드라마의 주연을 맡게 되었습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '정우성', '화보 공개', '새로운 화보를 공개합니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '한효주', '영화 출연 소식', '새 영화에 출연하게 되었습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '이동욱', '드라마 컴백', '드라마로 컴백합니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '이하늬', '영화 시사회', '영화 시사회에 참석했습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '고소영', '광고 촬영', '새 광고 촬영을 했습니다.', 1, 1, 1, 0, SYSDATE);
INSERT INTO MVCBOARD (IDX, NAME, SUBJECT, CONTENT, GUP, LEV, SEQ, HIT, WRITEDATE) VALUES (MVCBOARD_SEQ.NEXTVAL, '김희선', '화보 촬영', '멋진 화보 촬영을 했습니다.', 1, 1, 1, 0, SYSDATE);