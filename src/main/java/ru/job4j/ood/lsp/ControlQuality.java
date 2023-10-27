package ru.job4j.ood.lsp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlQuality {
    List<Store> stores;

    public ControlQuality(List<Store> stores) {
        this.stores = stores;
    }

    public void saveGoods(Food food) {
       stores.forEach(s -> s.add(food));
    }

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

        Food apple = new Food("apple", sdf.parse("06/24/2024"), sdf.parse("06/24/2023"), 23.33);
        Store shop = new Shop();
        Store trash = new Trash();
        Store warehouse = new Warehouse();
        List stories =  new ArrayList<>(Arrays.asList(shop, trash, warehouse));
        ControlQuality control = new ControlQuality(stories);
        control.saveGoods(apple);
        System.out.println(shop.findAll());
        System.out.println(trash.findAll());
        System.out.println(warehouse.findAll());
    }
}
