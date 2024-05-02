CREATE TABLE member(
	member_no INT,
	member_id VARCHAR(20),
    member_pw VARCHAR(20),
    member_name VARCHAR(20),
    member_gender VARCHAR(1),
    member_point INT,
    member_reg_date DATETIME
);

INSERT INTO member VALUES (1, 'qwer', '1234', '홍길동', 'm',  0, '2021-01-01 12:11:30');
INSERT INTO member VALUES (2, 'java', '1234', '김유신', 'm',  0, '2021-01-02 03:20:54');
INSERT INTO member VALUES (3, 'haha', '1234', '신혜정', 'w', 0, now());
INSERT INTO member VALUES (4, 'tiger', '1234', '선우호랭', 'w', 0, '2020-12-25 05:43:11');
INSERT INTO member VALUES (5, 'green', '1234', '정그린', 'm', 0, '2018-06-12 07:21:08');
