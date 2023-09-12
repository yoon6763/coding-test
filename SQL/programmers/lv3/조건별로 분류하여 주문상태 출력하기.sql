-- 코드를 입력하세요
SELECT ORDER_ID,
    PRODUCT_ID,
    DATE_FORMAT(OUT_DATE,"%Y-%m-%d") AS 출고여부,
    IF (OUT_DATE <= '2022-05-01', '출고완료', IF(OUT_DATE > '2022-05-01', '출고대기', '출고미정'))
FROM FOOD_ORDER
ORDER BY ORDER_ID