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

-- 1)����(beverages)�� �̸� �� ���ݰ� �Բ� 
--   ���� ��� ������� ���� ���̸� �����Ϸ� �Ѵ�.
--   �־��� �� ������ �����Ͽ� �̸� ���Ͻÿ�.

-- 1. ���� ���� ����
SELECT
    MAX(price)
FROM
    beverages;

-- 2. ���� ������ �ۼ�
SELECT
    name  AS "�����",
    price AS "����",
    price - (
        SELECT
            MAX(price)
        FROM
            beverages
    )     AS "�ִ� ���ݰ��� ����"
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
	price > ( -- ������ ��հ��� (4950��)
			SELECT 
				AVG(price)
			FROM
			beverages
			);
            
            
commit;

