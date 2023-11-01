package ru.job4j.ood.lsp.parking;

import java.util.Date;

public class PassengerCar implements Car {
    String number;
    Date startDate;
    Date finishDate;
    int unit;

    public PassengerCar(String number) {
        this.number = number;
    }
}
