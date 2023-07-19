create or replace function f_delet_when_cunt_0()
returns integer
language 'plpgsql'
as
$$
    declare
        result integer;
    begin
	select into result count(price) from products where count = 0;
	delete from products where id in (select id from products where count = 0);       
    return result;
    end;
$$;