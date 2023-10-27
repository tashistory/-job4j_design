package ru.job4j.ood.lsp;


import java.util.List;

public interface Store {
    Food add(Food item);

    boolean replace(int id, Food item);

    boolean delete(int id);

    List<Food> findAll();

    List<Food> findByName(String item);

    Food findById(int id);
}

