-- 코드를 작성해주세요
SELECT ID, LENGTH FROM FISH_INFO
WHERE ID IN (
    SELECT ID FROM FISH_INFO
    ORDER BY LENGTH DESC
    )
ORDER BY LENGTH DESC, ID ASC
LIMIT 10;