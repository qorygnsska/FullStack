-- group by
-- �ϳ� �̻��� ���� �׷����� ��� �����Ͽ� �ϳ��� ����� ��Ÿ������ 
-- �׷��Լ��� null�� �����ϰ� ���
--  �׷�� ��� �ȿ��� ���� ���� ����� �� ����

-- having
--  �׷��� �� �÷��� �߿��� where ���� ������ ����ؾߵ� ��

-- select       6:���� ��� ���̺��� ���ϴ� �͸� ��ȸ
-- from         1:��� ���̺�
-- join         2:�߰� ���̺��� ���� ��,
-- where        3:���ϴ� �������� ���͸�
-- group by     4:�̾ �׷� ���� �з��� ����,
-- having       5:Ư�� �������� ���ϴ� �׷��� ����
-- order by     7:Ư�� �÷��� �������� ����
-- limit        8:������ ������ �� ����


-- ��ǰ��� ������ ��������, ���� �Ǹ�����(�Ǹŷ�, ����)�� ��ȸ
SELECT
    *
FROM
    products;

SELECT
    *
FROM
    order_details;

SELECT
    p.name                 AS ��ǰ��,
    p.price                AS ����,
    SUM(o.count)           AS �Ǹŷ�,
    SUM(p.price * o.count) AS ����
FROM
    products      p
    LEFT JOIN order_details o ON p.id = o.product_id
GROUP BY
    p.name,
    p.price;
    

-- ���� ������ 35000�� �̻��� ��ǰ�� ��ȸ�Ͻÿ�
SELECT
    p.name                 AS ��ǰ��,
    p.price                AS ����,
    SUM(o.count)           AS �Ǹŷ�,
    SUM(p.price * o.count) AS ����
FROM
    products      p
    LEFT JOIN order_details o ON p.id = o.product_id
GROUP BY
    p.name,
    p.price
HAVING
    SUM(p.price * o.count) >= 35000;
    
    
-- ���� ������ 2���� �̻��̸鼭, ���� �Ǹŷ��� 10�� �̻��� ��ǰ�� ��ȸ
SELECT
    p.name                 AS ��ǰ��,
    p.price                AS ����,
    SUM(o.count)           AS �Ǹŷ�,
    SUM(p.price * o.count) AS ����
FROM
    products      p
    LEFT JOIN order_details o ON p.id = o.product_id
GROUP BY
    p.name,
    p.price
HAVING SUM(p.price * o.count) >= 20000
       AND SUM(o.count) >= 10;
       
       
-- ���� ������ ���� ��ǰ�� ������ �������� �������� �����Ͽ� ��ȸ
SELECT
    p.name  AS ��ǰ��,
    p.price AS ����,
    nvl(SUM(o.count),
        0)  AS �Ǹŷ�,
    nvl(SUM(p.price * o.count),
        0)  AS ����
FROM
    products      p
    LEFT JOIN order_details o ON p.id = o.product_id
GROUP BY
    p.name,
    p.price
HAVING
    SUM(o.count) IS NULL
ORDER BY
    p.price;


-- ���� ���� ���� 5�� ��ǰ�� ��ȸ
-- limit ����;
-- ����Ŭ�� limit�� ����


-- ��������
-- ������ �ȿ� �� �ٸ� ������ ����
-- ��������(�� �ȿ� �ִ� �������� ���� �����ϰ�)
-- �� ������� �ۿ� �ִ� ������ �̿��ؼ� ���� ����� ��Ÿ����

-- ��Į�� ���� ����(scalar subquer)
--  ����ϴ� ��ġ�� select ��
--  ���� �÷�, ���� ���� ��ȯ�Ѵ�(1���� ��)

-- �ζ��� ��
--  ����ϴ� ��ġ�� from ��
--  ����� ��ȯ�� �� ������ ������� ������ �ȳ�

-- ��ø��������
--  where��, having��
--  ���� �÷� �Ǵ� ���� �� ��ȯ


-- �� ������ ��� �޿����� ���� �޿��� �ް� �ִ� ������ ���, �̸�, �����ڵ�, �޿� ��ȸ
-- where���� �����Լ� ��� �Ұ�
SELECT
    AVG(salary)
FROM
    employee;

-- 2. where���ȿ� ()�ȿ� 1���� �������� ���� �ִ´�.
SELECT
    emp_id,
    emp_name,
    job_code,
    salary
FROM
    employee
WHERE
    salary >= (
        SELECT
            AVG(salary)
        FROM
            employee
    );
    

-- ���� �� ��������
-- ���������� ��ȸ ��� �� ������ 1�϶�
-- ���� �� �������� �տ��� �Ϲ� ������ ���
-- < <=, >=, <>, =, ...

-- ���� �� ��������
--  ���������� ��ȸ�� ������� �������� ��� �����ִ� �⺻ ������ ��� �Ұ�
-- in, not, in, all, any�� ��� ����
-- �⺻ ������ ��� �Ұ�


-- 1. �μ� �� �߿� ���� ���� �޴� ����� ���� ��ȸ
SELECT
    MAX(salary)
FROM
    employee
GROUP BY
    dept_code;


-- ���� �� ��������

-- ����� �������� ���� �μ�, ���� ���޿� �ش��ϴ� ����� �̸�, ����, �μ�, �Ի��� ��ȸ
-- 1. ��������
SELECT
    dept_code,
    job_code
FROM
    employee
WHERE
        substr(emp_no, 8, 1) = 2
    AND ent_yn = 'Y';


-- 2. �ܺ�����
SELECT
    emp_name,
    dept_code,
    job_code,
    hire_date
FROM
    employee
WHERE
    ( dept_code, job_code ) IN (
        SELECT
            dept_code, job_code
        FROM
            employee
        WHERE
                substr(emp_no, 8, 1) = 2
            AND ent_yn = 'Y'
    )
ORDER BY
    1;
    
    
-- ���� �� ���� �� �������� 
-- ���������� ��ȸ ��� �÷��� ������ ���� ������ 
--  ������ �� ��������  

-- ���޺� �ּ� �޿��� �޴� ������ ���, �̸�, ����, �޿� ��ȸ
-- 1. ��������
SELECT
    job_code,
    MIN(salary)
FROM
    employee
GROUP BY
    job_code;

-- 2.
SELECT
    emp_id,
    emp_name,
    job_code,
    salary
FROM
    employee
WHERE
    ( job_code, salary ) IN (
        SELECT
            job_code, MIN(salary)
        FROM
            employee
        GROUP BY
            job_code
    );
    
    
-- ��Į�� �������� 
-- select ��     
--  �� ���̺��� ��� ���� ������ �� ����
--  �ϳ��� ���� ���� �����ϰ� �� �� �̻���  ���� 
--  ����� �� �� ����.
--  ��ġ�ϴ� ������ ������� NULL���� ������ ���ִ�.
--  order by�� ����� �� ����.

-- ��� ����� ���, �̸�, ������ ���, ������ �� ��ȸ
-- 1. ��������
SELECT
    e.emp_id,
    e.emp_name,
    e.manager_id,
    ( nvl((
        SELECT
            m.emp_name
        FROM
            employee m
        WHERE
            m.emp_id = e.manager_id
    ), '����') ) AS �����ڸ�
FROM
    employee e
ORDER BY
    1;


-- order by �������� ����� �� �ִ�.
-- ��� ������ ���, �̸�, �Ҽ� �μ��� ��ȸ �� 
-- �μ��� �������� ����

-- 1. ��������
SELECT
    dept_title
FROM
    department
WHERE
    dept_code = dept_id;


-- 2. ��������
SELECT
    emp_id,
    emp_name,
    dept_code
FROM
    employee
ORDER BY
    (
        SELECT
            dept_title
        FROM
            department
        WHERE
            dept_code = dept_id
    ) DESC NULLS LAST;





--------------------------------------------------------------------

-- ROWNUM
--  select �ؿ� �����Ϳ� �Ϸù�ȣ�� ���̴� ��!
-- Ư�� ���տ��� ���ϴ� �ุ �������� ������ ���� ������ �����ϴ� �뵵�� ���
-- �ӽ������� ���� ��ȣ�� �ο��ϴ� ���̱� ������ �ݵ�� 1���� ���;��Ѵ�.
SELECT
    *
FROM
    employee
WHERE
    ROWNUM <= 10;

SELECT
    *
FROM
    employee;

-- ���� 10���� �޿��� ������������ ��ȸ!
SELECT
    emp_id,
    emp_name,
    salary,
    ROWNUM
FROM
    employee
ORDER BY
    salary DESC;


-- �ֱ� �Ի��� ���� 10���� ���� ��ȸ
-- ���, �̸�
SELECT
    *
FROM
    (
        SELECT
            emp_id,
            emp_name,
            hire_date,
            ROWNUM AS row_number
        FROM
            employee
        ORDER BY
            hire_date DESC
    )
WHERE
    row_number <= 10;


-- �μ��ڵ尡 D5�� ���� 5���� ���� ��ȸ
-- ����̸�, �μ��ڵ�
SELECT
    emp_id,
    emp_name,
    dept_code,
    ROWNUM AS row_number
FROM
    employee
WHERE
    dept_code = 'D5';

SELECT
    *
FROM
    (
        SELECT
            emp_id,
            emp_name,
            dept_code,
            ROWNUM AS row_number
        FROM
            employee
        WHERE
            dept_code = 'D5'
    )
WHERE
    row_number <= 3;



-- �μ��ڵ� D2 �̰� ���� �ڵ尡 J4�� 1���� ���� ��ȸ
SELECT
    *
FROM
    (
        SELECT
            emp_id,
            emp_name,
            ROWNUM AS row_number
        FROM
            employee
        WHERE
                dept_code = 'D2'
            AND job_code = 'J4'
    )
WHERE
    row_number <= 1;
    
commit;