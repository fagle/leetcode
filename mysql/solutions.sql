
/* 175. Combine Two Tables */
/* Runtime: 755 ms */
select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;

/* 176. Second Highest Salary */
/* Runtime: 1681 ms */
select max(Salary) as SecondHighestSalary from Employee where Salary != (select max(Salary) from Employee);