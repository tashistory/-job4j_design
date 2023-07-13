insert into roles(role_name) values ('admin');
insert into roles(role_name) values ('user');

insert into rules(rule_name) values ('читать');
insert into rules(rule_name) values ('удалять');
insert into rules(rule_name) values ('записывать');

insert into latitedes(id_role, id_rule) values (5, 7);
insert into latitedes(id_role, id_rule) values (5, 8);
insert into latitedes(id_role, id_rule) values (5, 9);
insert into latitedes(id_role, id_rule) values (6, 7);
insert into latitedes(id_role, id_rule) values (6, 9);

insert into users(user_name, id_role) values ('Иван', 5);
insert into users(user_name, id_role) values ('Нина', 6);
insert into users(user_name, id_role) values ('Татьяна', 6);

insert into states(state_name) values ('открыта');
insert into states(state_name) values ('закрыта');
insert into states(state_name) values ('в обработке');

insert into categories(catigorie_name) values ('Ремонт компьютерной техники');
insert into categories(catigorie_name) values ('Ремонт бытовой техники');

insert into items(item_name, description, id_user, id_categori, id_state) values ('Ремонт монитора', 'Короткое замыкание', 9, 1, 7);
insert into items(item_name, description, id_user, id_categori, id_state) values ('Профилактика пылесоса', 'Очистка от пыли внутреннию часть', 10, 2, 9);

insert into coments(coment, id_item) values ('Быстро починили, не дорого', 3);
insert into coments(coment, id_item) values ('Результатом довольна', 3);

insert into attachs(links, id_item) values ('/files/1.jpg', 2);
insert into attachs(links, id_item) values ('/files/2.jpg', 3);