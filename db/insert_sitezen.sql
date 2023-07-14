insert into resedences(name) values ('Россия');
insert into resedences(name) values ('Узбекистан');
insert into resedences(name) values ('Кигизстан');
insert into resedences(name) values ('Таджикистан');

insert into resedences(name, parent_id) values ('Москва', 1);
insert into resedences(name, parent_id) values ('Санкт-Питербург', 1);
insert into resedences(name, parent_id) values ('Ташкент', 2);
insert into resedences(name, parent_id) values ('Самарканд', 2);
insert into resedences(name, parent_id) values ('Бишкек', 3);
insert into resedences(name, parent_id) values ('Иссикуль', 3);
insert into resedences(name, parent_id) values ('Душанбе', 4);
insert into resedences(name, parent_id) values ('Ура-Тюбе', 4);

insert into citezens(fullname, id_resedences) values ('Иванов', 5);
insert into citezens(fullname, id_resedences) values ('Петров', 6);
insert into citezens(fullname, id_resedences) values ('Гуломов', 7);
insert into citezens(fullname, id_resedences) values ('Зарипов', 8);
insert into citezens(fullname, id_resedences) values ('Тилипбоев', 9);
insert into citezens(fullname, id_resedences) values ('Ерланбоев', 10);
insert into citezens(fullname, id_resedences) values ('Тожиков', 11);
insert into citezens(fullname, id_resedences) values ('Рахимов', 12);
