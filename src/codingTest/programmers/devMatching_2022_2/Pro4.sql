SELECT DATE_FORMAT(PR.CREATED_AT, '%m') MONTH, P.NAME, PR.COUNT
FROM PLACES P, (
    SELECT PLACE_ID, CREATED_AT, COUNT(*) COUNT
    FROM PLACE_REVIEWS
    WHERE DATE(CREATED_AT) BETWEEN '2018-01-01' AND '2018-12-31'
    GROUP BY DATE_FORMAT(CREATED_AT, '%m')
) PR
WHERE P.ID = PR.PLACE_ID
GROUP BY MONTH
ORDER BY MONTH ASC;

-- SELECT COUNT(*)
-- FROM PLACE_REVIEWS
-- WHERE DATE(CREATED_AT) BETWEEN '2018-01-01' AND '2018-12-31';

-- SELECT DATE_FORMAT(CREATED_AT, '%m') MONTH
-- FROM PLACE_REVIEWS
-- GROUP BY MONTH;

-- SELECT PLACE_ID, CREATED_AT, COUNT(*) COUNT
-- FROM PLACE_REVIEWS
-- WHERE DATE(CREATED_AT) BETWEEN '2018-01-01' AND '2018-12-31'
-- GROUP BY DATE_FORMAT(CREATED_AT, '%m')
-- HAVING COUNT(*);