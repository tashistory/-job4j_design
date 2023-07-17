select * from departments d left join employees e on d.id = e.departments_id; 
select * from departments d right join employees e on d.id = e.departments_id; 
select * from departments d full join employees e on d.id = e.departments_id;
select * from departments d cross join employees e;

select distinct d.name from departments d left join employees e on d.id = e.departments_id where e.id is null;

select distinct d.name, e.name from departments d left join employees e on d.id = e.departments_id;
select distinct d.name, e.name from employees e right join departments d on d.id = e.departments_id;

