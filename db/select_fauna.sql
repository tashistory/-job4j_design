select * from fauna where name like '%fish%';
select * from fauna where avg_age >= 10000 And avg_age <= 21000;
select * from fauna where discovery_date is null;
select * from fauna where EXTRACT(YEAR FROM discovery_date) < 1950;

