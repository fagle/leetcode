/* 176. Second Highest Salary */
/* Runtime: 1681 ms */
select max(Salary) as SecondHighestSalary
from Employee
where Salary != (select max(Salary) from Employee);

/* beats 43.98% submissions */
/* Runtime: 867 ms */
CREATE TABLE Employee (Id INT, Salary INT);
INSERT INTO Employee VALUES (1, 100);
INSERT INTO Employee VALUES (2, 100);
INSERT INTO Employee VALUES (2, 200), (3, 300);
select max(Salary) as SecondHighestSalary
from Employee
where Salary != (
  select max(Salary)
  from Employee
  where Salary >= (select AVG(Salary) from Employee)
);

/* beats 41.27% submissions */
/* Runtime: 898 ms */
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Id IN (
  SELECT a.Id
  FROM Employee a, Employee b
  WHERE a.Salary < b.Salary
);

/* beats 40.07% submissions */
/* Runtime: 909 ms */
SELECT MAX(Salary) AS SecondHighestSalary
FROM Employee
WHERE Id IN (
  SELECT a.Id
  FROM Employee a
  WHERE a.Salary < (SELECT max(Salary) FROM Employee)
    and a.Salary >= (SELECT AVG(Salary) FROM Employee)
);

/* beats 84.50% submissions */
/* Runtime: 696 ms */
SELECT MAX(Salary) AS SecondHighestSalary
FROM (
  SELECT DISTINCT Salary
  FROM Employee
  ORDER BY Salary desc
  LIMIT 1, 1
) a;
