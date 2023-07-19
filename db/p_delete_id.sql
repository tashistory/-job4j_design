create or replace procedure p_delete_id(p_id integer)
language 'plpgsql'
as $$
    BEGIN
       delete from products p where p.id = p_id; 
    END;
$$;