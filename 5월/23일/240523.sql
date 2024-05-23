-- group by
-- 하나 이상의 행을 그룹으로 묶어서 연산하여 하나의 결과만 나타내려고 
-- 그룹함수는 null을 제외하고 계산
--  그룹된 결과 안에서 단일 행을 출력할 수 없다

-- having
--  그룹이 된 컬럼들 중에서 where 같은 조건을 사용해야될 때

-- select       6:최종 결과 테이블에서 원하는 것만 조회
-- from         1:대상 테이블에
-- join         2:추가 테이블을 붙인 뒤,
-- where        3:원하는 조건으로 필터링
-- group by     4:이어서 그룹 별로 분류한 다음,
-- having       5:특정 조건으로 원하는 그룹을 선별
-- order by     7:특정 컬럼을 기준으로 정렬
-- limit        8:가져올 데이터 수 지정


-- 상품명과 가격을 기준으로, 누적 판매정보(판매량, 매출)를 조회
SELECT
    *
FROM
    products;

SELECT
    *
FROM
    order_details;

SELECT
    p.name                 AS 상품명,
    p.price                AS 가격,
    SUM(o.count)           AS 판매량,
    SUM(p.price * o.count) AS 매출
FROM
    products      p
    LEFT JOIN order_details o ON p.id = o.product_id
GROUP BY
    p.name,
    p.price;
    

-- 누적 매출이 35000원 이상인 상품을 조회하시오
SELECT
    p.name                 AS 상품명,
    p.price                AS 가격,
    SUM(o.count)           AS 판매량,
    SUM(p.price * o.count) AS 매출
FROM
    products      p
    LEFT JOIN order_details o ON p.id = o.product_id
GROUP BY
    p.name,
    p.price
HAVING
    SUM(p.price * o.count) >= 35000;
    
    
-- 누적 매출이 2만원 이상이면서, 누적 판매량도 10개 이상인 상품을 조회
SELECT
    p.name                 AS 상품명,
    p.price                AS 가격,
    SUM(o.count)           AS 판매량,
    SUM(p.price * o.count) AS 매출
FROM
    products      p
    LEFT JOIN order_details o ON p.id = o.product_id
GROUP BY
    p.name,
    p.price
HAVING SUM(p.price * o.count) >= 20000
       AND SUM(o.count) >= 10;
       
       
-- 누적 매출이 없는 제품을 가격을 기준으로 오름차순 정렬하여 조회
SELECT
    p.name  AS 상품명,
    p.price AS 가격,
    nvl(SUM(o.count),
        0)  AS 판매량,
    nvl(SUM(p.price * o.count),
        0)  AS 매출
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


-- 누적 매출 상위 5개 상품을 조회
-- limit 개수;
-- 오라클은 limit가 없음


-- 서브쿼리
-- 쿼리문 안에 또 다른 쿼리가 들어간다
-- 서브쿼리(즉 안에 있는 쿼리문이 먼저 실행하고)
-- 그 결과앖을 밖에 있는 쿼리가 이용해서 최종 결과를 나타낸다

-- 스칼라 서브 쿼리(scalar subquer)
--  사용하는 위치는 select 절
--  단일 컬럼, 단일 행을 반환한다(1개의 값)

-- 인라인 뷰
--  사용하는 위치는 from 절
--  결과를 반환할 때 별명을 지어줘야 에러가 안남

-- 중첩서브쿼리
--  where절, having절
--  다중 컬럼 또는 다중 행 반환


-- 전 직원의 평균 급여보다 많은 급여를 받고 있는 직원의 사번, 이름, 직급코드, 급여 조회
-- where절은 집계함수 사용 불가
SELECT
    AVG(salary)
FROM
    employee;

-- 2. where절안에 ()안에 1번의 쿼리문을 집어 넣는다.
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
    

-- 단일 행 서브쿼리
-- 서브쿼리의 조회 결과 값 개수가 1일때
-- 단일 행 서브쿼리 앞에는 일반 연산자 사용
-- < <=, >=, <>, =, ...

-- 다중 행 서브쿼리
--  서브쿼리로 조회한 결과값이 여러개일 경우 위에있는 기본 연산자 사용 불가
-- in, not, in, all, any만 사용 가능
-- 기본 연산자 사용 불가


-- 1. 부서 별 중에 가장 많이 받는 사람의 월급 조회
SELECT
    MAX(salary)
FROM
    employee
GROUP BY
    dept_code;


-- 다중 열 서브쿼리

-- 퇴사한 여직원과 같은 부서, 같은 직급에 해당하는 사원의 이름, 직급, 부서, 입사일 조회
-- 1. 서브쿼리
SELECT
    dept_code,
    job_code
FROM
    employee
WHERE
        substr(emp_no, 8, 1) = 2
    AND ent_yn = 'Y';


-- 2. 외부쿼리
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
    
    
-- 다중 행 다중 열 서브쿼리 
-- 서브쿼리를 조회 결과 컬럼의 개수와 행의 개수가 
--  여러개 인 서브쿼리  

-- 직급별 최소 급여를 받는 직원의 사번, 이름, 직급, 급여 조회
-- 1. 서브쿼리
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
    
    
-- 스칼라 서브쿼리 
-- select 절     
--  딴 테이블에서 어떠한 값을 가져올 때 쓰임
--  하나의 값만 리턴 가능하고 두 개 이상의  값은 
--  결과로 줄 수 없다.
--  일치하는 데이터 없더라고 NULL값을 리턴할 수있다.
--  order by를 사용할 수 없다.

-- 모든 사원의 사번, 이름, 관리자 사번, 관리자 명 조회
-- 1. 서브쿼리
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
    ), '없음') ) AS 관리자명
FROM
    employee e
ORDER BY
    1;


-- order by 절에서도 사용할 수 있다.
-- 모든 직원의 사번, 이름, 소속 부서를 조회 후 
-- 부서명 내림차순 정렬

-- 1. 서브쿼리
SELECT
    dept_title
FROM
    department
WHERE
    dept_code = dept_id;


-- 2. 메인쿼리
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
--  select 해온 데이터에 일련번호를 붙이는 것!
-- 특정 집합에서 원하는 행만 가져오고 싶을때 행의 개수를 제한하는 용도로 사용
-- 임시적으로 행의 번호를 부여하는 것이기 때문에 반드시 1부터 나와야한다.
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

-- 상위 10명의 급여를 내림차순으로 조회!
SELECT
    emp_id,
    emp_name,
    salary,
    ROWNUM
FROM
    employee
ORDER BY
    salary DESC;


-- 최근 입사한 상위 10명의 직원 조회
-- 사번, 이름
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


-- 부서코드가 D5인 상위 5명의 직원 조회
-- 사원이름, 부서코드
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



-- 부서코드 D2 이고 직급 코드가 J4인 1명의 직원 조회
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