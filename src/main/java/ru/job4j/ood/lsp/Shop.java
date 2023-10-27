package ru.job4j.ood.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Shop extends AbstractStore  {
    private final List<Food> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;




    @Override
    public Food add(Food item) {
        long shelfLifePercentage = item.getShelfLifePercentage();

        if (shelfLifePercentage >= 25 && shelfLifePercentage < 100) {
            if (shelfLifePercentage > 75) {
                item.setDiscount(20);
            }
            System.out.println(shelfLifePercentage);
            item.setId(ids++);
            items.add(item);
            System.out.println(items.get(0));
        }
        return item;
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        Food apple = new Food("apple", sdf.parse("06/24/2024"), sdf.parse("06/24/2023"), 23.33);
        Store shop = new Shop();
        shop.add(apple);
        System.out.println(shop.findAll());
    }
}
