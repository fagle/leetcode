CREATE TABLE `onlineLog` (
  `record_time` varchar(20) DEFAULT NULL,
  `zid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `online_num` int(11) DEFAULT NULL,
  `id` double NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/* 测试数据3668014行 */

/* 查询最近各区最大在线人数情况 */
select c.*
from
  (
    select b.*
    from
      (select max(online_num) as online_num, sid from onlinelog group by sid) a
      join onlinelog b
    where a.online_num = b.online_num
      and a.sid = b.sid
    ORDER BY record_time desc
  ) c
GROUP BY sid;

/* 查询所有区最高在线人数情况 */
SELECT sum(online_num) as max_num, record_time
FROM onlineLog
GROUP BY record_time
ORDER BY max_num DESC
LIMIT 10;

/* 最近在线人数, 5.115s */
SELECT
  sum(online_num) AS current_num,
  record_time
FROM
  onlineLog
WHERE
  record_time IN (
    SELECT DISTINCT *
    FROM (
      SELECT record_time
      FROM onlinelog
      ORDER BY record_time DESC
      LIMIT 10
    ) as a
  )
GROUP BY
  record_time;

/* 最近在线人数，方法2, 3.729s */
SELECT
  sum(b.online_num) AS current_num,
  a.record_time
FROM
  onlineLog b,
  (
    SELECT max(record_time) AS record_time
    FROM onlineLog
  ) AS a
WHERE
  b.record_time = a.record_time
GROUP BY
  a.record_time;

/* 昨天这个时候的在线人数 */
SELECT
  sum(online_num) AS current_num,
  record_time
FROM
  onlineLog
WHERE
  record_time = DATE_FORMAT((SELECT DATE_SUB(NOW(), INTERVAL 1 DAY)), '%Y-%m-%d %H:%k:00');

/* 最近10次在线人数统计, 14.816s */
SELECT
  sum(online_num) AS current_num,
  record_time
FROM
  onlineLog
WHERE
  record_time IN (
    SELECT DISTINCT *
    FROM (
      SELECT DISTINCT record_time
      FROM onlinelog
      ORDER BY record_time DESC
      LIMIT 10
    ) AS a
  )
GROUP BY
  record_time;

/* 最近10次在线人数，方法2, 17.722s */
SELECT
  sum(b.online_num) AS current_num,
  a.record_time
FROM
  onlineLog b,
  (
    SELECT DISTINCT record_time AS record_time
    FROM onlineLog
    ORDER BY record_time DESC
    LIMIT 10
  ) AS a
WHERE
  b.record_time = a.record_time
GROUP BY
  a.record_time;

SELECT sid, online_num
FROM onlineLog
LEFT JOIN serverInfo ON serverInfo.serverid = sid % 1000
WHERE record_time = DATE_FORMAT((DATE_SUB(NOW(), INTERVAL 1 MINUTE)), '%Y-%m-%d %H:%k:00');
