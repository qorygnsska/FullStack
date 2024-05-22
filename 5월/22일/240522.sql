-- ���̺� ����(join)
--  ���̺�� ���� �����͸� �ϳ��� ��ġ�� ��!
-- inner ���� : ���� ���̺��� ������ �����ϴ� �͸� ��������� �����´�.

-- ������ ���, �̸�, �μ��ڵ�, �μ���
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
    
    
-- ���, �̸�, �����ڵ�, ����
-- ������ �÷����� �������� �ʾҴ�.
-- ����� �÷����� ���� �� ��찡 �ִ�.
-- ���̺���� �տ� ���� .�÷���
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

-- ����� ���� �ڵ�� ����.
-- using�� �̿��ϸ� �����ϴ� �÷����� ���� ���� 
-- �ߺ������� ������ �ʰ� �ϳ��� �÷��� �����´�.
-- �ߺ����� �÷����� �ƴϰ� ���� �ٸ� �÷��� ���
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


-- ���� join
-- �ϳ� �̻��� ���̺��� �������� �����ؼ�
-- �ϳ��� ����� ResultSet���� ��ȯ�Ѵ�.

-- ������ ���, ���� �̸�, �μ��ڵ�, �μ���, ����
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
-- ���̺��� �����ϴµ� �ϳ� �̻��� ������ �������� �ؼ� ������ �´� ����� �����´�

-- ANSI join 
--  join on �� �̿��ؼ� ���̺��� ����
--  �ߺ����� �÷��� �����ϰ� ���̺��� ����
--  �پ��� DBMS ���� ȣȯ���� ���� ������ �����
--  ansi ��� join�� ���� ����Ѵ�. 
--  �б� ����, ������ ��Ȯ�ϰ� ���δ�.
--  ���� ������ �� �� �������� ����.



-- oracle join
--  where�� �̿��ؼ� ���̺��� ���� 
--  �ߺ����� �÷��� �����ͼ� �ߺ����� �÷��� �ݵ��
--  ���̺���� �ۼ��ؾߵȴ�. 
--  ���� 
--   ���� ���̺��� ������ ���� ������ ������
--   sql �ۼ��� �������� �� ����.

--- 70���� (1970 ~ 1979) �� �����̸鼭
-- ������ ����� �̸��� �ֹι�ȣ, �μ���, ������ȸ

-- ���̺�
-- employee, ��� ���� ���̺�,
-- department �μ� ������ �����ϴ� ���̺�
-- job ���� ������ �����ϴ� ���̺�
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
    AND e.emp_name LIKE '��%';
    

-- �̸��� '��'�� ���� ����� ����ڵ�, ��� ��, ���� ��ȸ
SELECT
    emp_id,
    emp_name,
    job_name
FROM
         employee
    JOIN job USING ( job_code )
WHERE
    emp_name LIKE '%��%';

-- �μ� �ڵ尡 D5�̰ų� D6�� �����, ����, �μ��ڵ�, �μ���
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


-- ���ʽ��� �޴� ����� �����, �μ���, ������
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
    

-- �����, ���� ��, �μ� ��, ���� �� ��ȸ
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
    
    
-- �ѱ��̳� �Ϻ����� �ٹ����� ����� �����, �μ���, ������, ������ ��ȸ
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


-- �� ����� ���� �μ����� ���ϴ� ����� �̸� ��ȸ  
-- �Ȱ��� ���̺��� �����ؼ� �����͸� ���� ���� �ִ�.

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

-- �������� ����
--  �����ʹ� ���� �����Ǿ� �ִ� ��!

-- �ϴ�� ����
-- �ϳ��� �����Ͱ� ���� �����Ϳ� ���谡 �ִ�.
CREATE TABLE photo (
    id       NUMBER PRIMARY KEY,
    filename VARCHAR2(255),
    user_id  NUMBER,
    FOREIGN KEY ( user_id )
        REFERENCES user1 ( id )
);

-- ����� ���̺��� �������̺�, �������̺� ����
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

-- ������ ����
CREATE SEQUENCE user_seq;

CREATE SEQUENCE photo_seq;

CREATE SEQUENCE comment_seq;

-- user ������ ����
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


-- photo ������ ���� 
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


-- ���
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
    '�Ŀ�',
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

-- 1) ������ �Խ��� ������ ��� ��� ?
SELECT
    COUNT(DISTINCT user_id) AS user_count
FROM
    photo;

-- 2) 3�� ����� �޸� ������?
SELECT
    p.filename
FROM
         comments c
    JOIN photo p ON c.photo_id = p.id
WHERE
    c.id = 3;


-- 3) ����1�� �޸� ��� "��� ����",�ۼ��� "�г���"��ȸ
SELECT
    u.nickname,
    c.body
FROM
         comments c
    JOIN photo p ON c.photo_id = p.id
    JOIN user1 u ON u.id = c.user_id
WHERE
    c.photo_id = 1;


-- 4) ����5�� ���ϸ�� ���� �Խ��� �г����� ��ȸ
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

-- NULL ���� ���� ���ڵ� ����
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


-- 2�� ������ ���ƿ並 ���� ����� �г���, ���ϸ�
SELECT
    u.nickname,
    p.filename
FROM
         like3 l
    JOIN user1 u ON u.id = l.user_id
    JOIN photo p ON p.id = l.photo_id
WHERE
    p.id = 2; 


-- ��� ������ ���ϸ��� ��ȸ, �г��ӵ�
SELECT
    filename,
    nvl(nickname, '����')
FROM
    photo p
    LEFT JOIN user1 u ON p.user_id = u.id;


-- ��� ����� ������ ��ȸ, ����� �޸� ���� ���ϸ��� �ɼ�
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
-- ������ ��� �ֹ� ��� ��ȸ
SELECT
    u.nickname   AS �ֹ���,
    o.id         AS �ֹ���ȣ,
    o.status     AS �ֹ�����,
    o.created_at AS �ֹ��Ͻ�
FROM
         orders o
    JOIN users u ON o.user_id = u.id
WHERE
    u.nickname = '����';

-- ���� �ֹ��� ��� Ƚ�� ��ȸ

SELECT
    COUNT(*) AS �ֹ�Ƚ��
FROM
         orders o
    JOIN users u ON o.user_id = u.id
WHERE
    u.nickname = '����';
    

-- ���� ��� �ֹ��� ���� �ݾ��� ��ȸ
-- �ֹ��ڸ�      �ֹ���ȣ     �����ݾ�
-- ����		1		33640
-- ����             2       33110
-- ����             8       42520
-- ����            10       null
SELECT
    u.nickname AS �ֹ��ڸ�,
    o.id       AS �ֹ���ȣ,
    p.amount   AS �����ݾ�
FROM
         orders o
    JOIN users    u ON o.user_id = u.id
    JOIN payments p ON o.id = p.order_id
WHERE
    u.nickname = '����';
    

-- ������ �� ���� �ݾ��� ��ȸ
SELECT
    SUM(p.amount) AS �����ݾ�
FROM
         orders o
    JOIN users    u ON o.user_id = u.id
    JOIN payments p ON o.id = p.order_id
WHERE
    u.nickname = '����';

-- ��ǰ1 ����� �� �Ǹ� �ݾ��� 64,500�� ��ȸ
SELECT
    SUM(p.price) AS ���Ǹűݾ�
FROM
         order_details o
    JOIN products p ON o.product_id = p.id
WHERE
    p.id = 1;


------------------------------------------------------
-- �׷�ȭ
--  �����͸� Ư¡���� �з��Ͽ�, �̸� �������� �м��ϴ� ���

-- ����(payments) ���̺��� ���� ����� ���� �з��ϰ� ������ ����Ƚ���� ��ȸ
SELECT
    *
FROM
    payments;

SELECT
    ptype    AS ������,
    COUNT(*) AS "���� Ƚ��"
FROM
    payments
GROUP BY
    ptype
ORDER BY
    1;
    

-- ��ǰ(products) ���̺��� ���� Ÿ�Կ� ���� �з��ϰ� ������ ��ǰ ������ ��� ���� ��ȸ
select * from products;

select ptype as "��ǰ ���� Ÿ��", count(*) as "��ǰ ����", avg(price) as "��� ����"
from products
group by ptype;


-- �����(users)�� �ֹ�(orders) ���̺��� �����ϰ�, ����� �г��Ӻ� ��� �Ϸ� �ֹ� ���� ��ȸ

-- ����� �г���    ��� �Ϸ� �ֹ� ��
--      ����            3
--      ȣũ            2
select u.nickname as "����� �г���", count(o.status) as "��� �Ϸ� �ֹ� ��"
from users u
join orders o on u.id = o.user_id
where status = 'DELIVERED'
group by u.nickname;

-- ��ǰ�� �� �ֹ� Ƚ���� �ֹ� �ݾ��� ��ȸ
select sum(count) as "�� �ֹ� Ƚ��", p.price as "�ֹ� �ݾ�"
from order_details od
join products p on p.id = od.product_id
group by p.id, p.price;

COMMIT;