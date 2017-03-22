
/* 175. Combine Two Tables */
/* Runtime: 755 ms */
select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;

/* 176. Second Highest Salary */
/* Runtime: 1681 ms */
select max(Salary) as SecondHighestSalary from Employee where Salary != (select max(Salary) from Employee);

/* beats 43.98% submissions*/
/* Runtime: 867 ms */
CREATE TABLE Employee (Id INT , Salary INT );
INSERT INTO Employee VALUES (1, 100);
INSERT INTO Employee VALUES (2, 100);
INSERT INTO Employee VALUES (2, 200),(3, 300);
select max(Salary) as SecondHighestSalary from Employee where Salary != (select max(Salary) from Employee where Salary >= (select AVG (Salary) from Employee));

/* beats 41.27% submissions*/
/* Runtime: 898 ms */
SELECT MAX(Salary) AS SecondHighestSalary FROM Employee WHERE Id IN (SELECT a.Id FROM Employee a, Employee b WHERE a.Salary < b.Salary);

/* beats 40.07% submissions*/
/* Runtime: 909 ms */
SELECT MAX(Salary) AS SecondHighestSalary FROM Employee WHERE Id IN (SELECT a.Id FROM Employee a WHERE a.Salary < (SELECT max(Salary) FROM Employee) and a.Salary >= (SELECT AVG(Salary) FROM  Employee) );

/* beats 84.50% submissions*/
/* Runtime: 696 ms */
SELECT MAX(Salary) AS SecondHighestSalary FROM (SELECT DISTINCT Salary FROM Employee ORDER BY Salary desc LIMIT 1,1) a;

/* 177. Nth Highest Salary */
/* Runtime: 643 ms */
/* beats 90.04% submissions*/
delimiter $$
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE r int;
set r=N-1;
  RETURN (
      # Write your MySQL query statement below.
        SELECT MAX(Salary) FROM (SELECT DISTINCT Salary FROM Employee ORDER BY Salary DESC LIMIT r,1 ) a
  );
END
$$
delimiter ;

/* 196. Delete Duplicate Emails */
/* Runtime: 971 ms */
/* beats 58.93% submissions*/
/*
ALTER TABLE Person ADD COLUMN Email  VARCHAR (50);
UPDATE Person SET Email = 'd@wori.me' WHERE PersonId<3;
INSERT INTO Person VALUES (3,'wang', 'wu', 'ifagle@qq.com');
*/
CREATE TABLE Person (Id int, Email VARCHAR (50));
INSERT INTO Person VALUES (1, 'd@wori.me'),(2,'d@wori.me');
INSERT INTO Person VALUES (3, 'ifagle@qq.com');
DELETE a FROM Person a, Person b WHERE a.Email=b.Email AND a.Id>b.Id;

/* 181. Employees Earning More Than Their Managers */
/* Runtime: 988 ms */
/* beats 92.20% submissions*/
drop table if EXISTS Employee;
CREATE TABLE Employee (Id INT, Name VARCHAR(20), Salary INT , ManagerId INT );
insert into Employee values(1, 'joe', 70000, 3), (2, 'henry', 80000, 4), (3, 'sam', 60000, NULL ), (4, 'Max', 90000, NULL );
select a.Name as  Employee from Employee a, Employee b where  a.ManagerId = b.Id and a.Salary > b.Salary;

/* 182. Duplicate Emails */
/* Runtime: 762 ms */
/* beats 56.56% submissions*/
INSERT INTO Person VALUES (2,'d@wori.me');
select DISTINCT(a.Email) from Person a, Person b where  a.Id != b.Id and a.Email = b.Email;

/* 183. Customers Who Never Order */
/* Runtime: 615 ms */
/* beats 44.67% submissions*/
create table Customers (Id int, Name varchar(20));
create table Orders(Id int, CustomerId int);
insert into Customers values(1, 'joe'), (2, 'henry'), (3, 'sam'), (4, 'Max');
insert into Orders values(1, 3), (2,1);
select Name from Customers where Id not in (select Customers.Id from Customers JOIN Orders where Customers.Id = Orders.CustomerId);

CREATE TABLE `onlineLog` (
  `record_time` varchar(20) DEFAULT NULL,
  `zid` int(11) DEFAULT NULL,
  `sid` int(11) DEFAULT NULL,
  `online_num` int(11) DEFAULT NULL,
  `id` double NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


/* 查询最近各区最大在线人数情况 */
select c.*  from
  (select b.* from
    (select max(online_num) as online_num, sid from onlinelog group by sid )a
    join onlinelog b
  where a.online_num=b.online_num and a.sid=b.sid ORDER BY record_time desc)c
GROUP BY sid;

/* 查询所有区最高在线人数情况 */
SELECT sum(online_num) as max_num, record_time FROM onlineLog GROUP BY record_time ORDER BY max_num DESC LIMIT  10;

/* 最近在线人数, 5.115s */
SELECT
  sum(online_num) AS current_num,
  record_time
FROM
  onlineLog
WHERE
  record_time IN (SELECT DISTINCT * FROM (
    SELECT
      record_time
    FROM
      onlinelog
    ORDER BY
      record_time DESC
    LIMIT 10
  ) as a)
GROUP BY
  record_time;

/* 最近在线人数，方法2, 3.729s */
SELECT
  sum(b.online_num) AS current_num,
  a.record_time
FROM
  onlineLog b,
  (
    SELECT
      max(record_time) AS record_time
    FROM
      onlineLog
  ) AS a
WHERE
  b.record_time = a.record_time
GROUP BY
  a.record_time;

/* 最近10次在线人数统计,14.816s */
SELECT
  sum(online_num) AS current_num,
  record_time
FROM
  onlineLog
WHERE
  record_time IN (
    SELECT DISTINCT
      *
    FROM
      (
        SELECT DISTINCT
          record_time
        FROM
          onlinelog
        ORDER BY
          record_time DESC
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
    SELECT
      DISTINCT record_time AS record_time
    FROM
      onlineLog ORDER BY record_time DESC LIMIT 10
  ) AS a
WHERE
  b.record_time = a.record_time
GROUP BY
  a.record_time;
