create trigger tax_trigger_row
    after insert
    on products
    for each row
    execute procedure tax_row();