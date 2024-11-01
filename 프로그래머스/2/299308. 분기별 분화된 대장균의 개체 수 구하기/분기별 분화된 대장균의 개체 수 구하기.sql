SELECT CONCAT(QUARTER, 'Q') AS QUARTER, COUNT(*) AS ECOLI_COUNT
FROM (SELECT QUARTER(DIFFERENTIATION_DATE) AS QUARTER FROM ECOLI_DATA) Q
GROUP BY QUARTER
ORDER BY QUARTER