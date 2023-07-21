select * from customers cl join (select min(age) from customers) c_min on  cl.age = c_min.min;

select * from customers c where c.id not in (select customer_id from orders);