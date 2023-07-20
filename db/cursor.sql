BEGIN;
DECLARE
    cursor_products cursor for
                        select * from products;
						
MOVE LAST FROM cursor_products;

FETCH ABSOLUTE 15 FROM cursor_products;
FETCH ABSOLUTE 7 FROM cursor_products;
FETCH ABSOLUTE 2 FROM cursor_products;
FETCH FIRST FROM cursor_products;
CLOSE cursor_products;
Commit;