select
  a.親ID,
  a.名前,
  a.登録日,
  a.登録者ID,
  b.ユーザー名 as 登録者名,
  a.更新日,
  a.更新者ID,
  c.ユーザー名 as 更新者名
from
  親 a
  inner join ユーザー b
    on a.登録者ID = b.ユーザーID
  inner join ユーザー c
    on a.更新者ID = c.ユーザーID
where
  親ID = /* parentId */1