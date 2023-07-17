select avg(price) from devices;

select p.name, avg(d.price) from devices_people dp join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id group by p.name;

select p.name, avg(d.price) from devices_people dp join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id group by p.name;

select p.name, avg(d.price) from devices_people dp join people p on dp.people_id = p.id
join devices d on dp.device_id = d.id group by p.name having avg(d.price) > 500;