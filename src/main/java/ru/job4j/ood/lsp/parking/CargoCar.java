package ru.job4j.ood.lsp.parking;

import org.checkerframework.checker.units.qual.C;

import java.util.Date;

public class CargoCar implements Car {
    String number;
    Date startDate;
    Date finishDate;
    int unit;

    public CargoCar(String number, int unit) {
        this.number = number;
        this.unit = unit;
    }
}
