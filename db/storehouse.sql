drop table storehouse;
create table storehouse(
	id serial primary key,
	name varchar(255),
	part_number int,
	production_date date,
	arrival_date timestamp default NOW(),
	units boolean,
	quantity double precision,
	price money
);

insert into storehouse(name, part_number, production_date, units, quantity, price) values('Гречка', 6766565, '2023-06-05', true, 1000.0, 8000);

select * from storehouse;

update storehouse set name = 'Мука';

select * from storehouse;

delete from storehouse;

select * from storehouse;




