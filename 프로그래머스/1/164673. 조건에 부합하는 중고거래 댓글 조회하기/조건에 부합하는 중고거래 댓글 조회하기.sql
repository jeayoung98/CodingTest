SELECT B.TITLE, B.BOARD_ID, R.REPLY_ID, R.WRITER_ID, R.CONTENTS, DATE_FORMAT(R.CREATED_DATE, '%Y-%m-%d') AS CREATED_DATE
FROM USED_GOODS_BOARD B
JOIN USED_GOODS_REPLY R ON B.BOARD_ID = R.BOARD_ID
WHERE DATE_FORMAT(B.CREATED_DATE, '%Y-%m') = '2022-10'
ORDER BY R.CREATED_DATE ASC, B.TITLE ASC;