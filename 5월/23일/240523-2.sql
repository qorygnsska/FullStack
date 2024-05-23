SELECT
    *
FROM
    beverages;

SELECT
    *
FROM
    orders;

SELECT
    *
FROM
    order_details;

-- 1)음료(beverages)의 이름 및 가격과 함께 
--   가장 비싼 음료와의 가격 차이를 조사하려 한다.
--   주어진 두 쿼리를 조합하여 이를 구하시오.

-- 1. 단일 값이 생성
SELECT
    MAX(price)
FROM
    beverages;

-- 2. 메인 쿼리에 작성
SELECT
    name  AS "음료명",
    price AS "가격",
    price - (
        SELECT
            MAX(price)
        FROM
            beverages
    )     AS "최대 가격과의 차이"
FROM
    beverages;
    
    
3.----------

SELECT b.id, b.name, NVL(od.order_count, 0) AS order_count
FROM beverages b
LEFT JOIN (
    SELECT beverage_id, COUNT(order_id) AS order_count
    FROM order_details
    GROUP BY beverage_id
) od ON b.id = od.beverage_id;



4.-----------

SELECT
	name,
	price
FROM
	beverages
where 
	price > ( -- 음료의 평균가격 (4950원)
			SELECT 
				AVG(price)
			FROM
			beverages
			);
            
            
commit;

