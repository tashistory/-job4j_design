select t.name, p.name from product p join type t on p.type_id = t.id; 

select p.name from product p join type t on p.type_id = t.id where upper(t.name) = 'СЫР'; 
 
select name from product where name like '%мороженое%';

select name from product where expired_date < current_date;

select name, max(price) from product group by name;

select t.name, count(p.name) from product p join type t on p.type_id = t.id group by t.name; 

select t.name, p.name from product p join type t on p.type_id = t.id where upper(t.name) = 'СЫР' or upper(t.name) = 'МОЛОКО' order by t.name, p.name;

select t.name, count(p.name) from product p join type t on p.type_id = t.id group by t.name having count(p.name) < 4; 

