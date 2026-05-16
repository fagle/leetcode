/* 177. Nth Highest Salary */
/* Runtime: 643 ms */
/* beats 90.04% submissions */
delimiter $$
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE r int;
set r = N - 1;
  RETURN (
    SELECT MAX(Salary)
    FROM (
      SELECT DISTINCT Salary
      FROM Employee
      ORDER BY Salary DESC
      LIMIT r, 1
    ) a
  );
END
$$
delimiter ;
