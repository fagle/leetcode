/* 175. Combine Two Tables */
/* Runtime: 755 ms */
select FirstName, LastName, City, State
from Person
left join Address on Person.PersonId = Address.PersonId;
