insert into car_bodies(name) values ('Седан');
insert into car_bodies(name) values ('Хэтчбек');
insert into car_bodies(name) values ('Лифтбек');
insert into car_bodies(name) values ('Универсал');
insert into car_bodies(name) values ('Внедорожник');
insert into car_bodies(name) values ('Кабриолет');

insert into car_engines(name) values ('Бензиновы');
insert into car_engines(name) values ('Дизельный');
insert into car_engines(name) values ('Гибрид');
insert into car_engines(name) values ('Электродвигатель');

insert into car_transmissions(name) values ('Механическая');
insert into car_transmissions(name) values ('Робот');
insert into car_transmissions(name) values ('Автоматическая');
insert into car_transmissions(name) values ('Вариатор');

insert into cars(name, body_id, engine_id, transmission_id) values ('Беленькая', 1, 4, null);
insert into cars(name, body_id, engine_id, transmission_id) values ('Красненькая', 2, 3, 4);
insert into cars(name, body_id, engine_id, transmission_id) values ('Черненькая', 4, 2, 1);
insert into cars(name, body_id, engine_id, transmission_id) values ('Синенькая', 5, null, 3);



