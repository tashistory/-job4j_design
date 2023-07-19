create or replace function tax_row()
    returns trigger as
$$
    BEGIN
	   new.price = new.price + new.price * 0.3;
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';