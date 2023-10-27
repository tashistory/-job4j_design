package ru.job4j.ood.lsp;

import java.util.Date;

public class Warehouse extends AbstractStore {

    @Override
    public Food add(Food item, Date date) {
        LifePercentage lifePercentage = new LifePercentage();
        if (lifePercentage.get(item, date) < MINPROCENT) {
            item.setId(ids++);
            items.add(item);
        }
        return item;
    }
}
