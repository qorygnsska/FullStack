-- 조회
SELECT
    *
FROM
    employee;

-- 직원 전부의 사번과, 이름, 월급을 조회하는 구문
SELECT
    emp_id,
    emp_name,
    salary
FROM
    employee;

-- 직원 전부의 연봉 출력
-- 직원의 이름, 월급, 연봉
-- 컬럼명을 설정할 수 있는데 
-- 컬럼명 as 설정할 컬럼명 -> mysql과 동일
SELECT
    emp_id      AS 이름,
    salary      AS 월급,
    salary * 12 AS 연봉
FROM
    employee;

-- 리터럴
--  임의로 지정한 문자열을 select절에 사용하면
--  테이블에 데이터가 존재하는 것처럼 활용
SELECT
    emp_id,
    salary,
    '원' AS 단위
FROM
    employee;

-- 직원들의 직급 코드 조회
-- 중복되는 데이터가 있을 경우 중복을 제거하고 한번씩만 표시하고 싶을 때
-- distinct
-- select 절에 1회만 기술 가능하다
SELECT DISTINCT
    job_code
FROM
    employee;

-- where 절
-- 검색할 컬럼의 조건을 설정하여 행 결정
-- 부서코드가 D9인 직원의 이름, 부서코드 조회
SELECT
    emp_name,
    dept_code
FROM
    employee
WHERE
    dept_code = 'D9';
    
-- 급여가 4000000보다 많은 직원의 이름과 급여 조회
SELECT
    emp_name,
    salary
FROM
    employee
WHERE
    salary > 4000000;

-- 부서코드가 D6이고 급여가 200만원보다 많은 직원 이름, 부서 코드, 급여 조회
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
WHERE
        dept_code = 'D6'
    AND salary > 2000000;
    
-- 부서코드가 D6 이거나 급여가 200만원보다 많은 직원의 이름, 부서코드, 급여 조회
SELECT
    emp_name,
    dept_code,
    salary
FROM
    employee
WHERE
    dept_code = 'D6'
    OR salary > 2000000;
    
-- 연결 연산자
-- ||를 사용하여 여러 컬럼을 하나의 컬럼인 것 처럼
-- 연결하거나 컬럼과 리터럴을 연결함

-- 컬럼과 컬럼 연결
SELECT
    emp_id
    || emp_name
    || salary
FROM
    employee;

-- 컬럼과 리터럴 연결
SELECT
    emp_name
    || '의 월급은'
    || salary
    || '원 입니다.'
FROM
    employee;

-- 급여를 350만원보다 많이 받고 600만원보다 적게 받는 직원의 이름을 조회
SELECT
    emp_name
FROM
    employee
WHERE
    salary BETWEEN 3500000 AND 6000000;
    
-- 비교하려는 값이 지정한 특정 패턴을 만족하면 True 리턴
-- '%', '_' 를 사용한다.

-- '전'씨 성을 가진 직원의 이름과 급여 조회
SELECT
    emp_name,
    salary
FROM
    employee
WHERE
    emp_name LIKE '전%';

-- LIKE는 대소문자로 구분한다.
-- 대소문자 구별없이 검색 upper, lower 함수를 사용해서 값을 변경한 다음 검색
-- select * from 테이블명
-- where lower(컬럼명) like '';

-- 제외하고 검색 : NOT LIKE

-- LIKE 여러개 설정 가능하다. 연결 논리연산자 
-- select * from 테이블명
-- where  (컬럼명 LIKE '%희' OR 
--         컬럼명 LIKE '이%' OR
--         컬럼명 LIKE '%서%')

-- 핸드폰 앞 네자리중 첫번째 번호가 7인 직원 이름과 전화번호 조회
-- _ 언더바 검색 (_ 하나의 자리수) 문자열의 자리수 결정
-- ___7%
SELECT
    emp_name,
    phone
FROM
    employee
WHERE
    phone LIKE '___7%';

-- email id 중 '_'의 앞이 3개인 정보 출력
-- 해당 문자를 직접 조회할 수가 없다!
-- escape 문자 사용
-- 컬럼명 like '_이스케이프문자_%' ESCAPE '이스케이프 문자';
SELECT
    emp_name,
    email
FROM
    employee
WHERE
    email LIKE '___#_%' ESCAPE '#';

-- is null,  is not null
-- null 여부를 비교하는 연산자

-- 관리자도 없고 부서 배치도 받지 않은 직원 조회
SELECT
    emp_name
FROM
    employee
WHERE
    manager_id IS NULL
    AND dept_code IS NULL;
    
-- 부서 배치는 받지 않았지만 보너스를 지급받은 직원 조회
-- null 값을 표현하지 않고 다른 값으로 대체하고 싶을경우 nvl(컬럼명, 대체값)
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
--  비교하려는 값 목록에 일치하는 값이 있으면 true를 반환

-- D6 부서와 D8 부서원들의 이름, 부서코드, 급여 조회
SELECT
    emp_name  AS 직원명,
    dept_code AS 부서코드,
    salary    AS 월급
FROM
    employee
WHERE
    dept_code IN ( 'D6', 'D8' );

-- ‘J2’ 또는 ‘J7’ 직급 코드 중 급여를 2000000보다 많이 받는 직원의 이름, 급여, 직급코드 조회
-- AND연산이 OR연산보다 우선순위가 높기 때문에 OR연산에 괄호를 작성해야함
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

-- 함수(Function)
--  하나의 큰 프로그램에서 반복적으로 사용되는
--  부분을 분리하여 작성해 놓은 작은 서브 프로그램!
--  함수를 호출해서 값을 전달하면 결과를 리턴하는 방식

-- 단일 행 함수 
--  여러개의 전달값을 이용해서 결과값이 여러개
--  각 행 마다 반복적으로 적용되어 입력 받은 행의
--  개수가 다를 수있다.

-- 그룹 함수 
--  여러개의 전달값을 이용해서 결과가 한개 
--  특정 행들의 집합으로 그룹이 형성되어 적용된다.
-- 그룹당 1개의 결과만 반환한다.

-- length 
--  주어진 컬럼 값/ 문자열의 길이(문자열 개수)를 반환
--  char / string

SELECT
    emp_name,
    length(emp_name)
FROM
    employee;


-- lengthb
--  주어진 컬럼의 값/문자열의 길이(byte)반환

SELECT
    emp_name,
    lengthb(emp_name)
FROM
    employee;
    
    
-- LTRIM / RTRIM
--   주어진 컬럼,문자열의 왼쪽/오른쪽에서 지정한
--   문자에 포함된 모든 문자를 제거하는 함수


SELECT
    emp_name,
    ltrim(phone, '010'),
    rtrim(email, '@kh.or.kr')
FROM
    employee;


-- substr(string,위치,개수)
--  컬럼이나 문자열에서 지정한 위치 부터 지정한 개수의
--  문자열을 잘라내어 반환

-- 위치(posistion)
-- 문자열을 잘라낼 위치로 양수면 시작방향에서 지정한 수 
--  만틈 음수면 문자 끝 방향에서 지정한 수 만큼 자른다.
-- 개수
--  반환할 문자 개수(음수이거나 null)반환

SELECT
    substr('showmethemoney', 5, 2),
    substr('showmethemoney', 7),
    substr('showmethemoney', - 8, 3),
    substr('쇼 미 더 머 니', 2, 5)
FROM
    dual;
    

-- 연결연산자와 동일하게 사용되는 컬럼을 연결하는 함수 concat
-- 함수 concat(String, String)

-- replace(String, str1, str2)
-- 컬럼의 문자 혹은 문자열에서 특정 문자열로 바꾸는것!
SELECT
    replace('서울시 강남구 역삼동', '역삼동', '삼성동')
FROM
    dual;

-- 숫자 함수
-- 인자로 전달받은 숫자를 나누어 반환(MOD)
SELECT
    mod(10, 3),
    mod(10.9, 3),
    mod(- 10.9, - 3)
FROM
    dual;
    

-- round(number, position)
--  인자로 전달받은 숫자 혹은 컬럼에서 지정한 위치부터 반올림하여 값을 반환
-- position을 생략하면 기본값이 0
SELECT
    round(10.10),
    round(10.18),
    round(- 10.61),
    round(10.123456, 5)
FROM
    dual;

-- 전달받은 인자를 무조건 올림해서 반환( ceil)
-- 전달받은 인자를 무조건 내림해서 반환( floor)
    
-- 날짜 처리 함수
--  시스템에 저장되어 있는 현재 날짜 반환
-- +,- 연산자로 날짜의 일수를 더하기 및 빼기 연산 가능
-- date 타입으로 시간 데이터를 가져온다.
SELECT
    sysdate     AS 오늘,
    sysdate + 1 AS 내일,
    sysdate - 1 AS 어제
FROM
    dual;
    
-- months_between(date1, date2)
-- 인자로 날짜 두개를 전달받아 개월 수 차이를 숫자 데이터형으로 반환
-- date1 기준이 되는 날짜
-- date2 개월 수를 구하는 날짜

-- employee 테이블에서 사원의 이름, 입사일, 근무 개월수를 조회
-- 소수점은 버림
SELECT
    emp_name,
    hire_date,
    ceil(months_between(sysdate, hire_date)) AS 근무개월수
FROM
    employee;
    

-- ADD_Months(date1, date2)
-- 인자로 전달받은 날짜에 인자로 받은 숫자만큼 개월 수를 더하여 특정 날짜 반환
-- date1 기준이 되는 날짜
-- date2 더하려는 개월 수

-- employee 테이블에서 사원의 이름, 입사일, 입사 후 6개월이 된 날짜 조회
SELECT
    emp_name,
    hire_date,
    add_months(hire_date, 6) AS "입사 후 6개월 날짜"
FROM
    employee;
    
-- Next_day(date, String)
-- 인자로 전달받은 날짜에 인자로 받은 요일이 가장 가까운 날짜 반환
-- 구하려는 요일을 날짜로 쓰는데 1 = 일요일, 2 = 월요일, 3 = 화요일 ~
SELECT
    sysdate,
    next_day(sysdate, '월요일'),
    next_day(sysdate, 2),
    next_day(sysdate, '월')
    --next_day(sysdate, 'monday') 에러
FROM
    employee;

-- EXTRACT 날짜형식 뽑아오기
SELECT
    emp_name,
    EXTRACT(YEAR FROM hire_date)  year,
    EXTRACT(MONTH FROM hire_date) year,
    EXTRACT(DAY FROM hire_date)   year
FROM
    employee;
    
    
-- 형변환 함수
-- to_char 날짜형 혹은 숫자형을 문자형으로 변환
-- to_char(date, [format])
-- to_char(number, [format])
-- 앞에는 자료형
-- 문자형으로 변환 시 지정할 출력 형식
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
    
-- L local에 따라 달라지는 통화 기호
-- 999,999,999
-- 9의 개수는 표시할 수 있는 자리수를 나타낸다.
-- 000,000,000
-- 자리수에 숫자가 없으면 0으로 표시됨
-- 급여 5000 - > 000,005,000


-- to_date 문자형 혹은 숫자형을 날짜형으로 변환
-- to_date(char, format)
-- to_date(number, format)

-- employee에서 2000년도 이후 입사한 사원의
-- 사번과 이름, 입사일 조회
SELECT
    emp_id,
    emp_name,
    hire_date
FROM
    employee
WHERE
    hire_date >= TO_DATE(20000101, 'YYYYMMDD');

-- to_number 문자형을 숫자형으로 반환

-- decode 
--  비교하고자 하는 값 또는 컬럼이 조건식과 
--  같으면 결과 값 반환 
    
--DECODE(표현식, 조건1, 결과1, 조건2, 결과2, …, DEFAULT)
/*
* 표현식 : 값에 따라 선택을 다르게 할 컬럼 혹은 값
* 조건 : 해당 값이 참인지 거짓인지 여부 판단
* 결과 : 해당 조건과 일치하는 경우 반환할 값
* DEFAULT : 모든 조건이 불일치 시 반환할 값
*/

-- emp_no 주민번호에서 남, 여로 성별을 구별해서 이름과 주민번호와 성별을 출력
SELECT
    emp_id,
    emp_no,
    emp_name,
    decode(substr(emp_no, 8, 1),
           '1',
           '남',
           '2',
           '여') AS 성별
FROM
    employee;

-- case
--  비교하고자 하는 값 또는 컬럼이 조건식과 같으면
--  범위 값 가능
/*
 * CASE WHEN 조건1 THEN 결과1
        WHEN 조건2 THEN 결과2
        WHEN 조건3 THEN 결과3
        …
        ELSE 결과N
END

 */
SELECT
    emp_name,
    salary,
    CASE
        WHEN salary > 5000000 THEN
            '1등급'
        WHEN salary > 3500000 THEN
            '2등급'
        WHEN salary > 2000000 THEN
            '3등급'
        ELSE
            '4등급'
    END 등급
FROM
    employee;
    
    
-- 그룹함수
--  하나 이상의 행을 그룹으로 묶어서 연산하며, 총점, 평균, 최대값, 최소값

-- 직원 전체 사원 수 조회
SELECT
    COUNT(*)
FROM
    employee;

-- D5인 직원의 수
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


-- ORA-00937: 단일 그룹의 그룹 함수가 아닙니다
-- 일반 열인 emp_name으로 정보를 반환, 
-- 그룹함수인 count() 부서코드로 묶어서 반환을 해야될 지 몰라서 에러

-- 일반 열을 그룹화 하는 group by 절 이용
-- 실행은 되지만 원하는 결과가 안 나옴
SELECT
    emp_name,
    COUNT(dept_code)
FROM
    employee
GROUP BY
    emp_name;
    
-- order by
-- select 한 컬럼에 대해 정렬하는 구문!
-- select 구문의 가장 마지막에 작성하면 실행 순서도 가장 마지막이다.
/*
SELECT 컬럼 명 [, 컬럼명, …] 
FROM 테이블 명 
WHERE 조건식
ORDER BY 컬럼명 | 별칭 | 컬럼 순번 정렬방식 [NULLS FIRST | LAST];

기본적으로 모든 정렬은 오름차순을 기준으로 한다
ASC : 오름차순
DESC : 내림차순

desc 테이블명; -> 테이블 구조 확인
*/
-- employee 테이블 정렬
SELECT
    emp_name
FROM
    employee
ORDER BY
    emp_name DESC;
-- 오름차순은 키워드를 생략해도 됨

-- 직원의 월급이 높은 순으로 정렬
-- 만약 월급이 같다면 이름으로 내림차순 정렬
SELECT
    emp_name,
    salary
FROM
    employee
ORDER BY
    salary DESC,
    emp_name DESC;
    

-- 그룹함수는 단 한개의 결과 값만 산출하기 때문에
-- 그룹이 여러 개일 경우 오류 발생
-- 여러개의 결과 값을 산출하기 위해서 그룹함수가 적용될 그룹의 기준을 group by절에 작성

-- 부서별 급여 합을 구하시오!
SELECT
    dept_code,
    SUM(salary)
FROM
    employee
GROUP BY
    dept_code;

-- employee 테이블에서 부서코드, 그룹별 급여합계
-- 그룹 별 급여의 평균(정수처리)
-- 인원 수를 조회하고 부서 코드 순으로 정렬!
-- 자리수만큼, 찍어서 출력하는 to_char()로 변경
-- nvl() 널이 있으면 'no dept'
SELECT
    nvl(dept_code, 'no dept'),
    to_char(SUM(salary),
            '999,999,999') 급여합계,
    to_char(floor(AVG(salary)),
            '999,999,999') 평균,
    COUNT(*)               인원수
FROM
    employee
GROUP BY
    dept_code
ORDER BY
    dept_code;
    
-- employee테이블에서 부서 코드와 보너스받은 사원수
-- 조회하고 부서코드 순으로 정렬


-- EMPLOYEE테이블에서 성별과 성별 별 급여 평균(정수처리), 급여 합계, 인원 수 조회하고
--  인원수로 내림차순 정렬
SELECT
    decode(substr(emp_no, 8, 1),
           '1',
           '남',
           '2',
           '여') 성별,
    SUM(salary) 합계,
    COUNT(*)    "인원 수"
FROM
    employee
GROUP BY
    decode(substr(emp_no, 8, 1),
           '1',
           '남',
           '2',
           '여')
ORDER BY
    "인원 수" DESC;
    
-- employee 테이블에서 부서 코드 별로 같은 직급인 사원의 급여 합계를 조회
-- group by는 여러 컬럼을 그룹으로 묶을 수 있다!
SELECT
    dept_code,
    job_code,
    SUM(salary) "급여 합계"
FROM
    employee
GROUP BY
    dept_code,
    job_code
ORDER BY
    dept_code;
    
-- 17번 문제 답
-- 17.EMPLOYEE테이블에서 사원명, 입사일-오늘, 오늘-입사일 조회(단,각 별칭은 근무일수1, 근무일수2가 되도록 하고 모두 정수(내림), 양수가 되도록 처리)
-- ABS : 전달받은 숫자의 절대값 반환
select emp_name, floor(abs(hire_date - sysdate)) 근무일수1, floor(abs(sysdate - hire_date)) 근무일수2 from employee;