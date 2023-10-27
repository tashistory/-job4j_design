package ru.job4j.ood.lsp;

import java.util.ArrayList;
import java.util.List;

public abstract class AbstractStore implements Store {
    private List<Food> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;


    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < items.size(); index++) {
            if (items.get(index).getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }
    public abstract Food add(Food item);


    @Override
    public Food findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    @Override
    public boolean replace(int id, Food item) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            item.setId(id);
            items.set(i, item);
        }
        return rsl;
    }

    @Override
    public List<Food> findAll() {
        return List.copyOf(items);
    }

    @Override
    public List<Food> findByName(String key) {
        List<Food> rsl = new ArrayList<>();
        for (Food item : items) {
            if (key.equals(item.getName())) {
                rsl.add(item);
            }
        }
        return rsl;
    }

    @Override

    public boolean delete(int id) {
        int i = indexOf(id);
        boolean rsl = i != -1;
        if (rsl) {
            items.remove(i);
        }
        return rsl;
    }
}
