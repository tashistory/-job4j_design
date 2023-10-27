package ru.job4j.ood.lsp;

import java.util.Date;

public class Trash extends AbstractStore implements Store {

    @Override
    public Food add(Food item, Date date) {
        LifePercentage lifePercentage = new LifePercentage();
        if (lifePercentage.get(item, date) >= FULPROCENT) {
            item.setId(ids++);
            items.add(item);
        }
        return item;
    }
}
