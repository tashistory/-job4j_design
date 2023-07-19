create or replace trigger tax_trigger_row
    before insert
    on products
    for each row
    execute procedure tax_row();