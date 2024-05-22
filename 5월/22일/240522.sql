-- 테이블 조인(join)
--  테이블로 나뉜 데이터를 하나로 합치는 것!
-- inner 조인 : 양쪽 테이블에서 조건을 만족하는 것만 결과앖으로 가져온다.

-- 직원의 사번, 이름, 부서코드, 부서명
SELECT
    emp_id,
    emp_name,
    dept_code,
    dept_title
FROM
    employee,
    department
WHERE
    dept_code = dept_id;
    
    
-- 사번, 이름, 직급코드, 직급
-- 위에는 컬럼명이 동일하지 않았다.
-- 현재는 컬럼명이 동일 한 경우가 있다.
-- 테이블명을 앞에 쓰고 .컬럼명
SELECT
    emp_id,
    emp_name,
    e.job_code,
    job_name
FROM
    employee e,
    job      j
WHERE
    e.job_code = j.job_code;

-- 결과는 위의 코드와 같다.
-- using을 이용하면 연결하는 컬럼명이 같을 때는 
-- 중복적으로 붙이지 않고 하나의 컬럼만 가져온다.
-- 중복적인 컬럼명이 아니고 각각 다른 컬럼일 경우
-- on()
SELECT
    emp_id,
    emp_name,
    job_code,
    job_name
FROM
         employee
    JOIN job USING ( job_code );

SELECT
    emp_id,
    emp_name,
    dept_code,
    dept_title
FROM
         employee
    JOIN department ON ( dept_code = dept_id );


-- 다중 join
-- 하나 이상의 테이블에서 여러개를 연결해서
-- 하나의 결과를 ResultSet으로 반환한다.

-- 직원의 사번, 직원 이름, 부서코드, 부서명, 지부
SELECT
    emp_id,
    emp_name,
    dept_code,
    dept_title,
    local_name
FROM
         employee
    JOIN department ON ( dept_code = dept_id )
    JOIN location ON ( location_id = local_code );

-- left join
-- 테이블을 연결하는데 하나 이상을 왼쪽을 기준으로 해서 조건이 맞는 결과만 가져온다

-- ANSI join 
--  join on 을 이용해서 테이블을 연결
--  중복적인 컬럼을 제거하고 테이블을 연결
--  다양한 DBMS 에서 호환성이 좋기 때문에 현재는
--  ansi 기법 join을 많이 사용한다. 
--  읽기 쉽고, 조건이 명확하게 보인다.
--  여러 조인을 할 때 가독성이 좋다.



-- oracle join
--  where를 이용해서 테이블을 연결 
--  중복적인 컬럼을 가져와서 중복적인 컬럼명 반드시
--  테이블명을 작성해야된다. 
--  단점 
--   여러 테이블을 연결할 때의 조건이 많으면
--   sql 작성시 가독성이 안 좋다.

--- 70년대생 (1970 ~ 1979) 중 여자이면서
-- 전씨인 사원의 이름과 주민번호, 부서명, 직급조회

-- 테이블
-- employee, 사원 정보 테이블,
-- department 부서 정보를 저장하는 테이블
-- job 직급 정보를 저장하는 데이블
SELECT
    e.emp_name,
    e.emp_no,
    d.dept_title,
    j.job_name
FROM
         employee e
    JOIN department d ON e.dept_code = d.dept_id
    JOIN job        j ON j.job_code = e.job_code
WHERE
    substr(e.emp_no, 1, 2) BETWEEN '70' AND '79'
    AND substr(e.emp_no, 8, 1) = '2'
    AND e.emp_name LIKE '전%';
    

-- 이름에 '형'이 들어가는 사원의 사원코드, 사원 명, 직급 조회
SELECT
    emp_id,
    emp_name,
    job_name
FROM
         employee
    JOIN job USING ( job_code )
WHERE
    emp_name LIKE '%형%';

-- 부서 코드가 D5이거나 D6인 사원명, 직급, 부서코드, 부서명
SELECT
    emp_name,
    job_name,
    dept_code,
    dept_title
FROM
         employee
    JOIN job USING ( job_code )
    JOIN department ON dept_code = dept_id
WHERE
    dept_code = 'D5'
    OR dept_code = 'D6';


-- 보너스를 받는 사원의 사원명, 부서명, 지역명
SELECT
    emp_name,
    bonus,
    dept_title,
    local_name
FROM
         employee
    JOIN department ON ( dept_code = dept_id )
    JOIN location ON ( location_id = local_code )
WHERE
    bonus IS NOT NULL;
    

-- 사원명, 직급 명, 부서 명, 지역 명 조회
SELECT
    emp_name,
    job_name,
    dept_title,
    local_name
FROM
         employee
    JOIN job USING ( job_code )
    JOIN department ON ( dept_code = dept_id )
    JOIN location ON ( location_id = local_code );
    
    
-- 한국이나 일본에서 근무중인 사원의 사원명, 부서명, 지역명, 국가명 조회
SELECT
    emp_name,
    dept_title,
    local_name,
    national_name
FROM
         employee
    JOIN department ON ( dept_code = dept_id )
    JOIN location ON ( location_id = local_code )
    JOIN national USING ( national_code )
WHERE
    national_code IN ( 'KO', 'JP' );


-- 한 사원과 같은 부서에서 일하는 사원의 이름 조회  
-- 똑같은 테이블을 연결해서 데이터를 얻어올 수도 있다.

SELECT
    e.emp_name,
    e.dept_code,
    d.emp_name
FROM
         employee e
    JOIN employee d ON ( e.dept_code = d.dept_code )
WHERE
    e.emp_name != d.emp_name
ORDER BY
    1;

SELECT
    *
FROM
    location;

SELECT
    *
FROM
    job;

SELECT
    *
FROM
    department;

SELECT
    *
FROM
    employee;

SELECT
    *
FROM
    national;

CREATE TABLE user1 (
    id       NUMBER PRIMARY KEY,
    nickname VARCHAR2(50),
    email    VARCHAR2(100)
);

-- 데이터의 관계
--  데이터는 서로 연관되어 있는 것!

-- 일대다 관계
-- 하나의 데이터가 여러 데이터와 관계가 있다.
CREATE TABLE photo (
    id       NUMBER PRIMARY KEY,
    filename VARCHAR2(255),
    user_id  NUMBER,
    FOREIGN KEY ( user_id )
        REFERENCES user1 ( id )
);

-- 댓글이 테이블은 사진테이블, 유저테이블 연결
CREATE TABLE comments (
    id       NUMBER PRIMARY KEY,
    body     VARCHAR(1000),
    user_id  NUMBER,
    photo_id NUMBER,
    FOREIGN KEY ( user_id )
        REFERENCES user1 ( id ),
    FOREIGN KEY ( photo_id )
        REFERENCES photo ( id )
);

-- 시퀀스 생성
CREATE SEQUENCE user_seq;

CREATE SEQUENCE photo_seq;

CREATE SEQUENCE comment_seq;

-- user 데이터 저장
INSERT INTO user1 (
    id,
    nickname,
    email
) VALUES (
    user_seq.NEXTVAL,
    'cloudstudying_kr',
    'mail@cloudstudying.kr'
);

INSERT INTO user1 (
    id,
    nickname,
    email
) VALUES (
    user_seq.NEXTVAL,
    'park_cs',
    'sehongpark@cloudstudying.kr'
);

INSERT INTO user1 (
    id,
    nickname,
    email
) VALUES (
    user_seq.NEXTVAL,
    'haesamq',
    'haesamq@naver.com'
);


-- photo 데이터 저장 
INSERT INTO photo (
    id,
    filename,
    user_id
) VALUES (
    photo_seq.NEXTVAL,
    'cat-on-road.jpg',
    1
);

INSERT INTO photo (
    id,
    filename,
    user_id
) VALUES (
    photo_seq.NEXTVAL,
    'sunset-over-the-ocean.jpg',
    1
);

INSERT INTO photo (
    id,
    filename,
    user_id
) VALUES (
    photo_seq.NEXTVAL,
    'andromeda-galaxy.jpg',
    1
);

INSERT INTO photo (
    id,
    filename,
    user_id
) VALUES (
    photo_seq.NEXTVAL,
    'white-tiger.jpg',
    2
);

INSERT INTO photo (
    id,
    filename,
    user_id
) VALUES (
    photo_seq.NEXTVAL,
    'nero-the-black-cat.jpg',
    2
);

INSERT INTO photo (
    id,
    filename
) VALUES (
    photo_seq.NEXTVAL,
    'deleted-image.jpg'
);

INSERT INTO photo (
    id,
    filename
) VALUES (
    photo_seq.NEXTVAL,
    'blocked-image.jpg'
);


-- 댓글
INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    'meow',
    1,
    1
);

INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    'nyaong',
    2,
    1
);

INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    '냐옹',
    3,
    1
);

INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    'sunset',
    1,
    2
);

INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    'falling slowly',
    2,
    2
);

INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    'Andromeda galaxy',
    1,
    3
);

INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    'mysteriouse..!',
    3,
    3
);

INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    'wow..!',
    3,
    NULL
);

INSERT INTO comments (
    id,
    body,
    user_id,
    photo_id
) VALUES (
    comment_seq.NEXTVAL,
    'oh..!',
    3,
    NULL
);

-- 1) 사진을 게시한 유저는 모두 몇명 ?
SELECT
    COUNT(DISTINCT user_id) AS user_count
FROM
    photo;

-- 2) 3번 댓글이 달린 사진은?
SELECT
    p.filename
FROM
         comments c
    JOIN photo p ON c.photo_id = p.id
WHERE
    c.id = 3;


-- 3) 사진1에 달린 모든 "댓글 내용",작성자 "닉네임"조회
SELECT
    u.nickname,
    c.body
FROM
         comments c
    JOIN photo p ON c.photo_id = p.id
    JOIN user1 u ON u.id = c.user_id
WHERE
    c.photo_id = 1;


-- 4) 사진5에 파일명과 사진 게시자 닉네임을 조회
SELECT
    p.filename,
    u.nickname
FROM
         photo p
    JOIN user1 u ON u.id = p.user_id
WHERE
    p.id = 5;

CREATE TABLE like3 (
    id       NUMBER PRIMARY KEY,
    user_id  NUMBER,
    photo_id NUMBER,
    FOREIGN KEY ( user_id )
        REFERENCES user1 ( id ),
    FOREIGN KEY ( photo_id )
        REFERENCES photo ( id )
);

CREATE SEQUENCE like_seq;

INSERT INTO like3 (
    id,
    user_id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    1,
    1
);

INSERT INTO like3 (
    id,
    user_id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    2,
    1
);

INSERT INTO like3 (
    id,
    user_id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    1,
    2
);

INSERT INTO like3 (
    id,
    user_id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    2,
    2
);

INSERT INTO like3 (
    id,
    user_id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    3,
    2
);

INSERT INTO like3 (
    id,
    user_id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    1,
    3
);

INSERT INTO like3 (
    id,
    user_id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    3,
    3
);

-- NULL 값을 가진 레코드 삽입
INSERT INTO like3 (
    id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    6
);

INSERT INTO like3 (
    id,
    photo_id
) VALUES (
    like_seq.NEXTVAL,
    7
);


-- 2번 사진에 좋아요를 누른 사용자 닉네임, 파일명
SELECT
    u.nickname,
    p.filename
FROM
         like3 l
    JOIN user1 u ON u.id = l.user_id
    JOIN photo p ON p.id = l.photo_id
WHERE
    p.id = 2; 


-- 모든 사진의 파일명을 조회, 닉네임도
SELECT
    filename,
    nvl(nickname, '없음')
FROM
    photo p
    LEFT JOIN user1 u ON p.user_id = u.id;


-- 모든 댓글의 내용을 조회, 댓글이 달린 사진 파일명은 옵션
SELECT
    c.body,
    p.filename
FROM
    comments c
    LEFT JOIN photo    p ON p.id = c.photo_id;

SELECT
    *
FROM
    comments;

SELECT
    *
FROM
    photo;

SELECT
    *
FROM
    user1;


-----------market---------------------
-- 서희의 모든 주문 목록 조회
SELECT
    u.nickname   AS 주문자,
    o.id         AS 주문번호,
    o.status     AS 주문상태,
    o.created_at AS 주문일시
FROM
         orders o
    JOIN users u ON o.user_id = u.id
WHERE
    u.nickname = '서희';

-- 서희가 주문한 모든 횟수 조회

SELECT
    COUNT(*) AS 주문횟수
FROM
         orders o
    JOIN users u ON o.user_id = u.id
WHERE
    u.nickname = '서희';
    

-- 서희가 모든 주문별 결제 금액을 조회
-- 주문자명      주문번호     결제금액
-- 서희		1		33640
-- 서희             2       33110
-- 서희             8       42520
-- 서희            10       null
SELECT
    u.nickname AS 주문자명,
    o.id       AS 주문번호,
    p.amount   AS 결제금액
FROM
         orders o
    JOIN users    u ON o.user_id = u.id
    JOIN payments p ON o.id = p.order_id
WHERE
    u.nickname = '서희';
    

-- 서희의 총 결제 금액을 조회
SELECT
    SUM(p.amount) AS 결제금액
FROM
         orders o
    JOIN users    u ON o.user_id = u.id
    JOIN payments p ON o.id = p.order_id
WHERE
    u.nickname = '서희';

-- 상품1 돈까스의 총 판매 금액은 64,500원 조회
SELECT
    SUM(p.price) AS 총판매금액
FROM
         order_details o
    JOIN products p ON o.product_id = p.id
WHERE
    p.id = 1;


------------------------------------------------------
-- 그룹화
--  데이터를 특징별로 분류하여, 이를 기준으로 분석하는 기법

-- 결제(payments) 테이블을 결제 방법에 따라 분류하고 각각의 결제횟수를 조회
SELECT
    *
FROM
    payments;

SELECT
    ptype    AS 결제사,
    COUNT(*) AS "결제 횟수"
FROM
    payments
GROUP BY
    ptype
ORDER BY
    1;
    

-- 상품(products) 테이블을 보관 타입에 따라 분류하고 각각의 상품 개수와 평균 가격 조회
select * from products;

select ptype as "상품 보관 타입", count(*) as "상품 개수", avg(price) as "평균 가격"
from products
group by ptype;


-- 사용자(users)와 주문(orders) 테이블을 조인하고, 사용자 닉네임별 배송 완료 주문 수를 조회

-- 사용자 닉네임    배송 완료 주문 수
--      서희            3
--      호크            2
select u.nickname as "사용자 닉네임", count(o.status) as "배송 완료 주문 수"
from users u
join orders o on u.id = o.user_id
where status = 'DELIVERED'
group by u.nickname;

-- 상품별 총 주문 횟수와 주문 금액을 조회
select sum(count) as "총 주문 횟수", p.price as "주문 금액"
from order_details od
join products p on p.id = od.product_id
group by p.id, p.price;

COMMIT;