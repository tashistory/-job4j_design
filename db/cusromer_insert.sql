
insert into customers(first_name, last_name, age, country) 
values ('Иван', 'Петрович', 20, 'Россия'),
('Фёдор', 'Иванович', 17, 'Россия'),
('Николай', 'Фёдорович', 17, 'Россия'),
('Артемий', 'Никалаевич', 20, 'Россия'),
('Анатолий', 'Сергеевич', 20, 'Россия'),
('Сергей', 'Викторович', 25, 'Россия');



insert into orders(customer_id, amount) 
values (1, 4),
(2, 6),
(4, 35),
(4, 14),
(2, 13),
(1, 45);