insert into health_groups(name) values ('Группа 1');
insert into health_groups(name) values ('Группа 2');
insert into health_groups(name) values ('Группа 3');
insert into health_groups(name) values ('Группа 4');

insert into analises(name) values ('Ренген');
insert into analises(name) values ('ЭКГ');
insert into analises(name) values ('МРТ');
insert into analises(name) values ('МСКТ');

insert into hospitals(name, type, adress, phone) values ('Medical Life', true, 'г. Ташкент, Сергелинский рай-он', '998(99)4564354');
insert into hospitals(name, type, adress, phone) values ('Поликлиника 1', false, 'г. Ташкент, Мирзоулугбекский рай-он', '998(71)2554532');

insert into specialytyes(name) values ('Гастроэнтеролог');
insert into specialytyes(name) values ('Терапевт');
insert into specialytyes(name) values ('Нервопотолог');
insert into specialytyes(name) values ('Хирург');

insert into drugs(name) values ('Фестал');
insert into drugs(name) values ('Атеналол');
insert into drugs(name) values ('Кавинтон');
insert into drugs(name) values ('Левомиколь');

insert into doctors(name, id_speciality) values ('Ардаков Игорь Герасимович', 9);
insert into doctors(name, id_speciality) values ('Донченко Иван Андреевич', 10);	
insert into doctors(name, id_speciality) values ('Кулагина Юлия Анатольевна', 11);
insert into doctors(name, id_speciality) values ('Бирюков Евгений Евгеньевич', 12);
insert into doctors(name, id_speciality) values ('Гришина Ольга Константиновна', 9);


insert into patients(name, birth, adress, phone, id_helthe_group) values ('Гришина Ольга Константиновна', '1956-06-05', 'Ташкент', '4343554', 9);
insert into patients(name, birth, adress, phone) values ('Карсева Полина Алексеевна', '2002-05-03', 'Ташкент', '5656545');
insert into patients(name, birth, adress, phone, id_helthe_group) values ('Кулагина Юлия Анатольевна', '1975-01-03', 'Ташкент', '5656545', 10);
insert into patients(name, birth, adress, phone, id_helthe_group) values ('Логинов Сергей Николаевич', '1987-03-12', 'Ташкент', '5656545', 11);

insert into medical_historyes(diagnosis, anamnis, id_hospital, id_patient, id_doctors) values ('Текст',  'Текст', 5, 12, 14);
insert into medical_historyes(diagnosis, anamnis, id_hospital, id_patient, id_doctors) values ('Текст',  'Текст', 6, 14, 16);
insert into medical_historyes(diagnosis, anamnis, id_hospital, id_patient, id_doctors) values ('Текст',  'Текст', 5, 12, 12);


insert into historyes_analises(conclusion, id_history, id_analise) values ('Текст',  2, 10);
insert into historyes_analises(conclusion, id_history, id_analise) values ('Текст', 3, 11);


insert into recepts(type, id_history, id_drug) values (true, 2, 11);
insert into recepts(type, id_history, id_drug) values (true, 3, 9);












