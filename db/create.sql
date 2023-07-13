create table roles(
    id serial primary key,
	role_name varchar(255)
);
create table rules(
	id serial primary key,
	rule_name varchar(255)
);
create table states(
	id serial primary key,
	state_name varchar(255)
);
create table users(
	id serial primary key,
	user_name varchar(255),
	id_role int references roles(id)
);
create table latitedes(
	id serial primary key,
	id_role int references roles(id),
	id_rule int references rules(id)
);
create table categories(
	id serial primary key,
	catigorie_name varchar(255),
);
create table items(
	id serial primary key,
	item_name varchar(255),
	description text,
	id_user int references users(id),
	id_categori int references categories(id)
	id_state int references states(id)
);
create table coments(
	id serial primary key,
	coment varchar(255),
	id_item int references items(id)
);
create table attachs(
	id serial primary key,
	links varchar(255),
	id_item int references items(id)
);