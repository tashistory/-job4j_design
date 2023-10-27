package ru.job4j.ood.lsp;

import java.util.Date;

public class LifePercentage {
    public long get(Food food, Date date) {
        return (date.getTime() - food.getCreateDate().getTime()) * 100 / (food.getExpiryDate().getTime() - food.getCreateDate().getTime());
    }

}
