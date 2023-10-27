package ru.job4j.ood.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ControlQuality {
    List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void saveGoods(Food food, Date date) {
       stores.forEach(s -> s.add(food, date));
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        Food apple = new Food("apple", sdf.parse("06/24/2024"), sdf.parse("06/24/2023"), 23.33);
        Store shop = new Shop();
        Store trash = new Trash();
        Store warehouse = new Warehouse();
        ControlQuality control = new ControlQuality(new ArrayList<>(Arrays.asList(shop, trash, warehouse)));
        control.saveGoods(apple, new java.util.Date());
        System.out.println(shop.findAll());
        System.out.println(trash.findAll());
        System.out.println(warehouse.findAll());
    }
}
