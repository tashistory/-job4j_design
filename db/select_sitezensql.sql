select * from citezens;

select ci.fullname "Ф.И.О", city.name "Город" from citezens ci 
join resedences city  on ci.id_resedences = city.id;

select ci.fullname "Ф.И.О", city.name "Город", country.name "Страна" from citezens ci 
join resedences city  on ci.id_resedences = city.id 
join resedences country on city.parent_id = country.id;

select ci.fullname "Ф.И.О", country.name "Страна" from citezens ci 
join resedences city  on ci.id_resedences = city.id 
join resedences country on city.parent_id = country.id;
