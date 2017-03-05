
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
