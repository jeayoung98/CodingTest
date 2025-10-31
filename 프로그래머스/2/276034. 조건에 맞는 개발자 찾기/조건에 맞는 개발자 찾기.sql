-- 코드를 작성해주세요
SELECT distinct d.id, d.email, d.first_name, d.last_name
FROM developers d
JOIN skillcodes s
  ON (d.skill_code & s.code) = s.code
WHERE s.name IN ('Python', 'C#')
ORDER BY d.id ASC;