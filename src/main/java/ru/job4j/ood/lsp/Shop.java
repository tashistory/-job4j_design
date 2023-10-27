package ru.job4j.ood.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Shop extends AbstractStore  {

    @Override
    public Food add(Food item, Date date) {

        LifePercentage lifePercentage = new LifePercentage();
        long shelfLifePercentage = lifePercentage.get(item, date);

        if (shelfLifePercentage >= MINPROCENT && shelfLifePercentage < FULPROCENT) {
            if (shelfLifePercentage > MAXPROCENT) {
                item.setDiscount(DISCONTPROCENT);
            }
            item.setId(ids++);
            items.add(item);
        }
        return item;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Food apple = new Food("apple", sdf.parse("06/24/2024"), sdf.parse("06/24/2023"), 23.33);
        Store shop = new Shop();
        Store warehouse = new Warehouse();
        Store trash = new Trash();
        //shop.add(apple);
        System.out.println(shop.findAll());
        System.out.println(warehouse.findAll());
        System.out.println(trash.findAll());
    }
}
