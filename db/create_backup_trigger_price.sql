create trigger backup_trigger_price
    after insert
    on products
    for each row
    execute procedure bakup_price();