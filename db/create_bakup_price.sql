create or replace function bakup_price()
    returns trigger as
$$
    BEGIN
        insert into history_of_price(name, price) values(new.name, new.price);
        return NEW;
    END;
$$
LANGUAGE 'plpgsql';