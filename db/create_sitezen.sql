create table resedences(
    id serial primary key,
    name varchar(255),
    parent_id int references resedences(id)
);

create table citezens(
    id serial primary key,
    fullname varchar(255),
    id_resedences int references resedences(id)
);
