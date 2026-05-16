/* 181. Employees Earning More Than Their Managers */
/* Runtime: 988 ms */
/* beats 92.20% submissions */
drop table if EXISTS Employee;
CREATE TABLE Employee (Id INT, Name VARCHAR(20), Salary INT, ManagerId INT);
insert into Employee values
  (1, 'joe', 70000, 3),
  (2, 'henry', 80000, 4),
  (3, 'sam', 60000, NULL),
  (4, 'Max', 90000, NULL);

select a.Name as Employee
from Employee a, Employee b
where a.ManagerId = b.Id
  and a.Salary > b.Salary;
