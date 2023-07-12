create table truck(
    id serial primary key,
    model varchar(255),
	mpg int,
	fuel boolean,
	carrying double precision
);

create table garage(
    id _number primary key,
	gov_number varchar(6),
    id_truck int references truck(id)
);


create driver driver(
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
    id_driver int references driver(id),
	gov_number varchar(6) references garage(gov_number)
);

create table information_driver(
    date_of_birth date,
	experience int,
	final_mileage,
	domicile varchar(255),
	id int references driver(id)
);

