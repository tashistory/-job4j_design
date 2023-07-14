create table trucks(
    id serial primary key,
    model varchar(255),
	mpg int,
	fuel boolean,
	carrying double precision,
	garage_id references truck(id)
);

create table garages(
   id  serial primary key,
   name varchar(255)
);


create table driver(
    id serial primary key,
    full_name varchar(255),
	number_phone int
);


create table invoice(
    id _number primary key,
	curent_date timestamp default NOW(),
	initial_mileage int,
	final_mileage,
	load double precision,
	id_truck int references truck(id),
    id_driver int references driver(id)
);

create table information_driver(
    date_of_birth date,
	experience int,
	final_mileage,
	domicile varchar(255),
	id int references driver(id) unique
);

