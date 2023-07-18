create table health_groups(
	id serial primary key,
	name varchar(255)
);

create table analises(
	id serial primary key,
	name varchar(255)
);

create table hospitals(
	id serial primary key,
	name varchar(255),
	type bool,
	adress varchar(255),
	phone varchar(16)
);

create table specialytyes(
	id serial primary key,
	name varchar(255)
);

create table drugs(
	id serial primary key,
	name varchar(255)
);

create table doctors(
	id serial primary key,
	name varchar(255),
	id_speciality int references specialytyes(id)
);

create table patients(
	id serial primary key,
	name varchar(255),
	birth date,
	adress varchar(255),
	phone varchar(16),
	id_helthe_group int references health_groups(id)
);

create table medical_historyes(
	id serial primary key,
	diagnosis varchar(255),
	anamnis varchar(255),
	c_date date default current_date,
	id_hospital int references hospitals(id),
	id_patient int references patients(id),
	id_doctors int references doctors(id)
);

create table historyes_analises(
	conclusion varchar(255),
	c_date date default current_date,
	id_history int references medical_historyes(id),
	id_analise int references analises(id)
);


create table recepts(
	id serial primary key,
	type bool,
	c_date date default current_date,
	id_history int references medical_historyes(id),
	id_drug int references drugs(id)
);
