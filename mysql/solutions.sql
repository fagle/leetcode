select FirstName, LastName, City, State from Person left join Address on Person.PersonId = Address.PersonId;

select max(Salary) as SecondHighestSalary from Employee where Salary != (select max(Salary) from Employee);