-- 코드를 작성해주세요
SELECT DISTINCT ID, EMAIL, FIRST_NAME, LAST_NAME
FROM SKILLCODES S, DEVELOPERS D
WHERE CONV(SKILL_CODE, 10, 2)%(CONV(CODE, 10, 2)*10) >= CONV(CODE, 10, 2)
AND CATEGORY = 'Front End'
ORDER BY ID