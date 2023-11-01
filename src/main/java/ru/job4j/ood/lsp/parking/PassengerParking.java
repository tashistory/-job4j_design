package ru.job4j.ood.lsp.parking;

import java.util.List;

public class PassengerParking implements Parking {
    int size;

    public PassengerParking(int i) {
    }

    @Override
    public Car add(Car car) {
        return null;
    }

    @Override
    public List<Integer> findPlaceByNumber(String number) {
        return null;
    }

    @Override
    public Car exit(String number) {
        return null;
    }

    @Override
    public List<Car> findAll() {
        return null;
    }

    @Override
    public Car findByPlace(int place) {
        return null;
    }
}

