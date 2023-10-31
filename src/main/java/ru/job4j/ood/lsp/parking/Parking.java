package ru.job4j.ood.lsp.parking;

import java.util.List;

public interface Parking {
    Car add(Car car);
    List<Integer> findPlaceByNumber(String number);
    Car exit(String number);
    List<Car> findAll();
    Car findByPlace(int place);
}
