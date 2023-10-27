package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public class Trash extends AbstractStore implements Store {
    private final List<Food> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;

    @Override
    public Food add(Food item) {
        if (item.getShelfLifePercentage() >= 100) {
            item.setId(ids++);
            items.add(item);
        }
        return item;
    }

}
