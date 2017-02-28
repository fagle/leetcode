
/* 175. Combine Two Tables */
/* Runtime: 755 ms */
select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;

/* 176. Second Highest Salary */
/* Runtime: 1681 ms */
select max(Salary) as SecondHighestSalary from Employee where Salary != (select max(Salary) from Employee);

/* beats 43.98% submissions*/
/* Runtime: 867 ms */
select max(Salary) as SecondHighestSalary from Employee where Salary != (select max(Salary) from Employee where Salary >= (select AVG (Salary) from Employee));

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