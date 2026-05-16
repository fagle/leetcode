/* 183. Customers Who Never Order */
/* Runtime: 615 ms */
/* beats 44.67% submissions */
create table Customers (Id int, Name varchar(20));
create table Orders (Id int, CustomerId int);
insert into Customers values
  (1, 'joe'),
  (2, 'henry'),
  (3, 'sam'),
  (4, 'Max');
insert into Orders values (1, 3), (2, 1);

select Name
from Customers
where Id not in (
  select Customers.Id
  from Customers
  JOIN Orders
  where Customers.Id = Orders.CustomerId
);
