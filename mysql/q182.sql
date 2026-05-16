/* 182. Duplicate Emails */
/* Runtime: 762 ms */
/* beats 56.56% submissions */
INSERT INTO Person VALUES (2, 'd@wori.me');

select DISTINCT(a.Email)
from Person a, Person b
where a.Id != b.Id
  and a.Email = b.Email;
