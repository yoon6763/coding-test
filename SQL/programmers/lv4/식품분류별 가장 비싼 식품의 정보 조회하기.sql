-- 코드를 입력하세요
SELECT CATEGORY,
    (SELECT PRICE FROM FOOD_PRODUCT F2 WHERE F1.CATEGORY = F2.CATEGORY ORDER BY PRICE DESC LIMIT 1) AS MAX_PRICE,
    (SELECT PRODUCT_NAME FROM FOOD_PRODUCT F2 WHERE F1.CATEGORY = F2.CATEGORY ORDER BY PRICE DESC LIMIT 1) AS PRODUCT_NAME
FROM FOOD_PRODUCT F1
WHERE CATEGORY = '과자' OR CATEGORY = '국' OR CATEGORY = '김치' OR CATEGORY = '식용유'
GROUP BY CATEGORY
ORDER BY MAX_PRICE DESC