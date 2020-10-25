select
  親ID,
  子ID,
  上位子ID,
  名前,
  登録日,
  -- 登録者ID,
  更新日
  -- 更新者ID
from
  子
where
  子ID = /* 子id */1
