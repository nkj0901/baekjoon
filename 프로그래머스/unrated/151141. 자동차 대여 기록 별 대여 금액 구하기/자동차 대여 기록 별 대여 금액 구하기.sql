# SELECT DATEDIFF(END_DATE, START_DATE)+1, START_DATE, END_DATE
# FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY

# SELECT SUBSTR(DURATION_TYPE, 1, INSTR(DURATION_TYPE, "일")-1)
# FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN

WITH A AS (
    SELECT HISTORY_ID, C.CAR_TYPE, DATEDIFF(END_DATE, START_DATE)+1 PERIOD, DAILY_FEE,
    CASE
        WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 90 THEN "90일 이상"
        WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 30 THEN "30일 이상"
        WHEN DATEDIFF(END_DATE, START_DATE)+1 >= 7 THEN "7일 이상"
    END DURATION_TYPE
    FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY H
    JOIN CAR_RENTAL_COMPANY_CAR C
    ON H.CAR_ID = C.CAR_ID
)

SELECT HISTORY_ID, ROUND(DAILY_FEE * PERIOD * ((100-IFNULL(DISCOUNT_RATE,0))/100)) FEE
FROM A
LEFT JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
ON A.DURATION_TYPE = P.DURATION_TYPE AND A.CAR_TYPE = P.CAR_TYPE
WHERE A.CAR_TYPE = '트럭'
ORDER BY FEE DESC, HISTORY_ID DESC