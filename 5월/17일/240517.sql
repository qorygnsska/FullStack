-- ��ȸ
SELECT
    *
FROM
    employee;

-- ���� ������ �����, �̸�, ������ ��ȸ�ϴ� ����
SELECT
    emp_id,
    emp_name,
    salary
FROM
    employee;

-- ���� ������ ���� ���
-- ������ �̸�, ����, ����
-- �÷����� ������ �� �ִµ� 
-- �÷��� as ������ �÷��� -> mysql�� ����
SELECT
    emp_id      AS �̸�,
    salary      AS ����,
    salary * 12 AS ����
FROM
    employee;

-- ���ͷ�
--  ���Ƿ� ������ ���ڿ��� select���� ����ϸ�
--  ���̺� �����Ͱ� �����ϴ� ��ó�� Ȱ��
SELECT
    emp_id,
    salary,
    '��' AS ����
FROM
    employee;

-- �������� ���� �ڵ� ��ȸ
-- �ߺ��Ǵ� �����Ͱ� ���� ��� �ߺ��� �����ϰ� �ѹ����� ǥ���ϰ� ���� ��
-- distinct
-- select ���� 1ȸ�� ��� �����ϴ�
SELECT DISTINCT
    job_code
FROM
    employee;

-- where ��
-- �˻��� �÷��� ������ �����Ͽ� �� ����
-- �μ��ڵ尡 D9�� ������ �̸�, �μ��ڵ� ��ȸ
SELECT
    emp_name,
    dept_code
FROM
    employee
WHERE
    dept_code = 'D9';
    
-- �޿��� 4000000���� ���� ������ �̸��� �޿� ��ȸ
SELECT
    emp_name,
    salary
FROM
    employee
WHERE
    salary > 4000000;

-- �μ��ڵ尡 D6�̰� �޿��� 200�������� ���� ���� �̸�, �μ� �ڵ�, �޿� ��ȸ
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
WHERE
        dept_code = 'D6'
    AND salary > 2000000;
    
-- �μ��ڵ尡 D6 �̰ų� �޿��� 200�������� ���� ������ �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
WHERE
    dept_code = 'D6'
    OR salary > 2000000;
    
-- ���� ������
-- ||�� ����Ͽ� ���� �÷��� �ϳ��� �÷��� �� ó��
-- �����ϰų� �÷��� ���ͷ��� ������

-- �÷��� �÷� ����
SELECT
    emp_id
    || emp_name
    || salary
FROM
    employee;

-- �÷��� ���ͷ� ����
SELECT
    emp_name
    || '�� ������'
    || salary
    || '�� �Դϴ�.'
FROM
    employee;

-- �޿��� 350�������� ���� �ް� 600�������� ���� �޴� ������ �̸��� ��ȸ
SELECT
    emp_name
FROM
    employee
WHERE
    salary BETWEEN 3500000 AND 6000000;
    
-- ���Ϸ��� ���� ������ Ư�� ������ �����ϸ� True ����
-- '%', '_' �� ����Ѵ�.

-- '��'�� ���� ���� ������ �̸��� �޿� ��ȸ
SELECT
    emp_name,
    salary
FROM
    employee
WHERE
    emp_name LIKE '��%';

-- LIKE�� ��ҹ��ڷ� �����Ѵ�.
-- ��ҹ��� �������� �˻� upper, lower �Լ��� ����ؼ� ���� ������ ���� �˻�
-- select * from ���̺��
-- where lower(�÷���) like '';

-- �����ϰ� �˻� : NOT LIKE

-- LIKE ������ ���� �����ϴ�. ���� �������� 
-- select * from ���̺��
-- where  (�÷��� LIKE '%��' OR 
--         �÷��� LIKE '��%' OR
--         �÷��� LIKE '%��%')

-- �ڵ��� �� ���ڸ��� ù��° ��ȣ�� 7�� ���� �̸��� ��ȭ��ȣ ��ȸ
-- _ ����� �˻� (_ �ϳ��� �ڸ���) ���ڿ��� �ڸ��� ����
-- ___7%
SELECT
    emp_name,
    phone
FROM
    employee
WHERE
    phone LIKE '___7%';

-- email id �� '_'�� ���� 3���� ���� ���
-- �ش� ���ڸ� ���� ��ȸ�� ���� ����!
-- escape ���� ���
-- �÷��� like '_�̽�����������_%' ESCAPE '�̽������� ����';
SELECT
    emp_name,
    email
FROM
    employee
WHERE
    email LIKE '___#_%' ESCAPE '#';

-- is null,  is not null
-- null ���θ� ���ϴ� ������

-- �����ڵ� ���� �μ� ��ġ�� ���� ���� ���� ��ȸ
SELECT
    emp_name
FROM
    employee
WHERE
    manager_id IS NULL
    AND dept_code IS NULL;
    
-- �μ� ��ġ�� ���� �ʾ����� ���ʽ��� ���޹��� ���� ��ȸ
-- null ���� ǥ������ �ʰ� �ٸ� ������ ��ü�ϰ� ������� nvl(�÷���, ��ü��)
SELECT
    emp_name,
    nvl(dept_code, 'No dept') AS dept_code,
    bonus
FROM
    employee
WHERE
    dept_code IS NULL
    AND bonus IS NOT NULL;

-- IN
--  ���Ϸ��� �� ��Ͽ� ��ġ�ϴ� ���� ������ true�� ��ȯ

-- D6 �μ��� D8 �μ������� �̸�, �μ��ڵ�, �޿� ��ȸ
SELECT
    emp_name  AS ������,
    dept_code AS �μ��ڵ�,
    salary    AS ����
FROM
    employee
WHERE
    dept_code IN ( 'D6', 'D8' );

-- ��J2�� �Ǵ� ��J7�� ���� �ڵ� �� �޿��� 2000000���� ���� �޴� ������ �̸�, �޿�, �����ڵ� ��ȸ
-- AND������ OR���꺸�� �켱������ ���� ������ OR���꿡 ��ȣ�� �ۼ��ؾ���
SELECT
    emp_name,
    salary,
    job_code
FROM
    employee
WHERE
    ( job_code = 'J7'
      OR job_code = 'J2' )
    AND salary > 2000000;

-- �Լ�(Function)
--  �ϳ��� ū ���α׷����� �ݺ������� ���Ǵ�
--  �κ��� �и��Ͽ� �ۼ��� ���� ���� ���� ���α׷�!
--  �Լ��� ȣ���ؼ� ���� �����ϸ� ����� �����ϴ� ���

-- ���� �� �Լ� 
--  �������� ���ް��� �̿��ؼ� ������� ������
--  �� �� ���� �ݺ������� ����Ǿ� �Է� ���� ����
--  ������ �ٸ� ���ִ�.

-- �׷� �Լ� 
--  �������� ���ް��� �̿��ؼ� ����� �Ѱ� 
--  Ư�� ����� �������� �׷��� �����Ǿ� ����ȴ�.
-- �׷�� 1���� ����� ��ȯ�Ѵ�.

-- length 
--  �־��� �÷� ��/ ���ڿ��� ����(���ڿ� ����)�� ��ȯ
--  char / string

SELECT
    emp_name,
    length(emp_name)
FROM
    employee;


-- lengthb
--  �־��� �÷��� ��/���ڿ��� ����(byte)��ȯ

SELECT
    emp_name,
    lengthb(emp_name)
FROM
    employee;
    
    
-- LTRIM / RTRIM
--   �־��� �÷�,���ڿ��� ����/�����ʿ��� ������
--   ���ڿ� ���Ե� ��� ���ڸ� �����ϴ� �Լ�


SELECT
    emp_name,
    ltrim(phone, '010'),
    rtrim(email, '@kh.or.kr')
FROM
    employee;


-- substr(string,��ġ,����)
--  �÷��̳� ���ڿ����� ������ ��ġ ���� ������ ������
--  ���ڿ��� �߶󳻾� ��ȯ

-- ��ġ(posistion)
-- ���ڿ��� �߶� ��ġ�� ����� ���۹��⿡�� ������ �� 
--  ��ƴ ������ ���� �� ���⿡�� ������ �� ��ŭ �ڸ���.
-- ����
--  ��ȯ�� ���� ����(�����̰ų� null)��ȯ

SELECT
    substr('showmethemoney', 5, 2),
    substr('showmethemoney', 7),
    substr('showmethemoney', - 8, 3),
    substr('�� �� �� �� ��', 2, 5)
FROM
    dual;
    

-- ���Ῥ���ڿ� �����ϰ� ���Ǵ� �÷��� �����ϴ� �Լ� concat
-- �Լ� concat(String, String)

-- replace(String, str1, str2)
-- �÷��� ���� Ȥ�� ���ڿ����� Ư�� ���ڿ��� �ٲٴ°�!
SELECT
    replace('����� ������ ���ﵿ', '���ﵿ', '�Ｚ��')
FROM
    dual;

-- ���� �Լ�
-- ���ڷ� ���޹��� ���ڸ� ������ ��ȯ(MOD)
SELECT
    mod(10, 3),
    mod(10.9, 3),
    mod(- 10.9, - 3)
FROM
    dual;
    

-- round(number, position)
--  ���ڷ� ���޹��� ���� Ȥ�� �÷����� ������ ��ġ���� �ݿø��Ͽ� ���� ��ȯ
-- position�� �����ϸ� �⺻���� 0
SELECT
    round(10.10),
    round(10.18),
    round(- 10.61),
    round(10.123456, 5)
FROM
    dual;

-- ���޹��� ���ڸ� ������ �ø��ؼ� ��ȯ( ceil)
-- ���޹��� ���ڸ� ������ �����ؼ� ��ȯ( floor)
    
-- ��¥ ó�� �Լ�
--  �ý��ۿ� ����Ǿ� �ִ� ���� ��¥ ��ȯ
-- +,- �����ڷ� ��¥�� �ϼ��� ���ϱ� �� ���� ���� ����
-- date Ÿ������ �ð� �����͸� �����´�.
SELECT
    sysdate     AS ����,
    sysdate + 1 AS ����,
    sysdate - 1 AS ����
FROM
    dual;
    
-- months_between(date1, date2)
-- ���ڷ� ��¥ �ΰ��� ���޹޾� ���� �� ���̸� ���� ������������ ��ȯ
-- date1 ������ �Ǵ� ��¥
-- date2 ���� ���� ���ϴ� ��¥

-- employee ���̺��� ����� �̸�, �Ի���, �ٹ� �������� ��ȸ
-- �Ҽ����� ����
SELECT
    emp_name,
    hire_date,
    ceil(months_between(sysdate, hire_date)) AS �ٹ�������
FROM
    employee;
    

-- ADD_Months(date1, date2)
-- ���ڷ� ���޹��� ��¥�� ���ڷ� ���� ���ڸ�ŭ ���� ���� ���Ͽ� Ư�� ��¥ ��ȯ
-- date1 ������ �Ǵ� ��¥
-- date2 ���Ϸ��� ���� ��

-- employee ���̺��� ����� �̸�, �Ի���, �Ի� �� 6������ �� ��¥ ��ȸ
SELECT
    emp_name,
    hire_date,
    add_months(hire_date, 6) AS "�Ի� �� 6���� ��¥"
FROM
    employee;
    
-- Next_day(date, String)
-- ���ڷ� ���޹��� ��¥�� ���ڷ� ���� ������ ���� ����� ��¥ ��ȯ
-- ���Ϸ��� ������ ��¥�� ���µ� 1 = �Ͽ���, 2 = ������, 3 = ȭ���� ~
SELECT
    sysdate,
    next_day(sysdate, '������'),
    next_day(sysdate, 2),
    next_day(sysdate, '��')
    --next_day(sysdate, 'monday') ����
FROM
    employee;

-- EXTRACT ��¥���� �̾ƿ���
SELECT
    emp_name,
    EXTRACT(YEAR FROM hire_date)  year,
    EXTRACT(MONTH FROM hire_date) year,
    EXTRACT(DAY FROM hire_date)   year
FROM
    employee;
    
    
-- ����ȯ �Լ�
-- to_char ��¥�� Ȥ�� �������� ���������� ��ȯ
-- to_char(date, [format])
-- to_char(number, [format])
-- �տ��� �ڷ���
-- ���������� ��ȯ �� ������ ��� ����
SELECT
    emp_name,
    to_char(hire_date, 'YYYY-MM-DD'),
    to_char(hire_date, 'YY/MON,DAY,DY')
FROM
    employee;

SELECT
    emp_name,
    to_char(salary, 'L999,999,999'),
    to_char(salary, '000,000,000')
FROM
    employee;
    
-- L local�� ���� �޶����� ��ȭ ��ȣ
-- 999,999,999
-- 9�� ������ ǥ���� �� �ִ� �ڸ����� ��Ÿ����.
-- 000,000,000
-- �ڸ����� ���ڰ� ������ 0���� ǥ�õ�
-- �޿� 5000 - > 000,005,000


-- to_date ������ Ȥ�� �������� ��¥������ ��ȯ
-- to_date(char, format)
-- to_date(number, format)

-- employee���� 2000�⵵ ���� �Ի��� �����
-- ����� �̸�, �Ի��� ��ȸ
SELECT
    emp_id,
    emp_name,
    hire_date
FROM
    employee
WHERE
    hire_date >= TO_DATE(20000101, 'YYYYMMDD');

-- to_number �������� ���������� ��ȯ

-- decode 
--  ���ϰ��� �ϴ� �� �Ǵ� �÷��� ���ǽİ� 
--  ������ ��� �� ��ȯ 
    
--DECODE(ǥ����, ����1, ���1, ����2, ���2, ��, DEFAULT)
/*
* ǥ���� : ���� ���� ������ �ٸ��� �� �÷� Ȥ�� ��
* ���� : �ش� ���� ������ �������� ���� �Ǵ�
* ��� : �ش� ���ǰ� ��ġ�ϴ� ��� ��ȯ�� ��
* DEFAULT : ��� ������ ����ġ �� ��ȯ�� ��
*/

-- emp_no �ֹι�ȣ���� ��, ���� ������ �����ؼ� �̸��� �ֹι�ȣ�� ������ ���
SELECT
    emp_id,
    emp_no,
    emp_name,
    decode(substr(emp_no, 8, 1),
           '1',
           '��',
           '2',
           '��') AS ����
FROM
    employee;

-- case
--  ���ϰ��� �ϴ� �� �Ǵ� �÷��� ���ǽİ� ������
--  ���� �� ����
/*
 * CASE WHEN ����1 THEN ���1
        WHEN ����2 THEN ���2
        WHEN ����3 THEN ���3
        ��
        ELSE ���N
END

 */
SELECT
    emp_name,
    salary,
    CASE
        WHEN salary > 5000000 THEN
            '1���'
        WHEN salary > 3500000 THEN
            '2���'
        WHEN salary > 2000000 THEN
            '3���'
        ELSE
            '4���'
    END ���
FROM
    employee;
    
    
-- �׷��Լ�
--  �ϳ� �̻��� ���� �׷����� ��� �����ϸ�, ����, ���, �ִ밪, �ּҰ�

-- ���� ��ü ��� �� ��ȸ
SELECT
    COUNT(*)
FROM
    employee;

-- D5�� ������ ��
SELECT
    COUNT(*)
FROM
    employee
WHERE
    dept_code = 'D5';

SELECT
    COUNT(dept_code)
FROM
    employee;


-- ORA-00937: ���� �׷��� �׷� �Լ��� �ƴմϴ�
-- �Ϲ� ���� emp_name���� ������ ��ȯ, 
-- �׷��Լ��� count() �μ��ڵ�� ��� ��ȯ�� �ؾߵ� �� ���� ����

-- �Ϲ� ���� �׷�ȭ �ϴ� group by �� �̿�
-- ������ ������ ���ϴ� ����� �� ����
SELECT
    emp_name,
    COUNT(dept_code)
FROM
    employee
GROUP BY
    emp_name;
    
-- order by
-- select �� �÷��� ���� �����ϴ� ����!
-- select ������ ���� �������� �ۼ��ϸ� ���� ������ ���� �������̴�.
/*
SELECT �÷� �� [, �÷���, ��] 
FROM ���̺� �� 
WHERE ���ǽ�
ORDER BY �÷��� | ��Ī | �÷� ���� ���Ĺ�� [NULLS FIRST | LAST];

�⺻������ ��� ������ ���������� �������� �Ѵ�
ASC : ��������
DESC : ��������

desc ���̺��; -> ���̺� ���� Ȯ��
*/
-- employee ���̺� ����
SELECT
    emp_name
FROM
    employee
ORDER BY
    emp_name DESC;
-- ���������� Ű���带 �����ص� ��

-- ������ ������ ���� ������ ����
-- ���� ������ ���ٸ� �̸����� �������� ����
SELECT
    emp_name,
    salary
FROM
    employee
ORDER BY
    salary DESC,
    emp_name DESC;
    

-- �׷��Լ��� �� �Ѱ��� ��� ���� �����ϱ� ������
-- �׷��� ���� ���� ��� ���� �߻�
-- �������� ��� ���� �����ϱ� ���ؼ� �׷��Լ��� ����� �׷��� ������ group by���� �ۼ�

-- �μ��� �޿� ���� ���Ͻÿ�!
SELECT
    dept_code,
    SUM(salary)
FROM
    employee
GROUP BY
    dept_code;

-- employee ���̺��� �μ��ڵ�, �׷캰 �޿��հ�
-- �׷� �� �޿��� ���(����ó��)
-- �ο� ���� ��ȸ�ϰ� �μ� �ڵ� ������ ����!
-- �ڸ�����ŭ, �� ����ϴ� to_char()�� ����
-- nvl() ���� ������ 'no dept'
SELECT
    nvl(dept_code, 'no dept'),
    to_char(SUM(salary),
            '999,999,999') �޿��հ�,
    to_char(floor(AVG(salary)),
            '999,999,999') ���,
    COUNT(*)               �ο���
FROM
    employee
GROUP BY
    dept_code
ORDER BY
    dept_code;
    
-- employee���̺��� �μ� �ڵ�� ���ʽ����� �����
-- ��ȸ�ϰ� �μ��ڵ� ������ ����


-- EMPLOYEE���̺��� ������ ���� �� �޿� ���(����ó��), �޿� �հ�, �ο� �� ��ȸ�ϰ�
--  �ο����� �������� ����
SELECT
    decode(substr(emp_no, 8, 1),
           '1',
           '��',
           '2',
           '��') ����,
    SUM(salary) �հ�,
    COUNT(*)    "�ο� ��"
FROM
    employee
GROUP BY
    decode(substr(emp_no, 8, 1),
           '1',
           '��',
           '2',
           '��')
ORDER BY
    "�ο� ��" DESC;
    
-- employee ���̺��� �μ� �ڵ� ���� ���� ������ ����� �޿� �հ踦 ��ȸ
-- group by�� ���� �÷��� �׷����� ���� �� �ִ�!
SELECT
    dept_code,
    job_code,
    SUM(salary) "�޿� �հ�"
FROM
    employee
GROUP BY
    dept_code,
    job_code
ORDER BY
    dept_code;
    
-- 17�� ���� ��
-- 17.EMPLOYEE���̺��� �����, �Ի���-����, ����-�Ի��� ��ȸ(��,�� ��Ī�� �ٹ��ϼ�1, �ٹ��ϼ�2�� �ǵ��� �ϰ� ��� ����(����), ����� �ǵ��� ó��)
-- ABS : ���޹��� ������ ���밪 ��ȯ
select emp_name, floor(abs(hire_date - sysdate)) �ٹ��ϼ�1, floor(abs(sysdate - hire_date)) �ٹ��ϼ�2 from employee;