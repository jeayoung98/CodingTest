-- 코드를 작성해주세요
SELECT
    i.item_id,
    i.item_name,
    i.rarity
FROM item_info i
JOIN item_tree t
  ON t.item_id = i.item_id
LEFT JOIN item_tree c
  ON c.parent_item_id = t.item_id
WHERE c.item_id IS NULL
ORDER BY i.item_id DESC;