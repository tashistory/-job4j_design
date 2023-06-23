package ru.job4j.serialization.java;

import java.util.Arrays;

public class Parking {
    private final Car[] car;
    private int itn;
    private final String name;
    private boolean open;

    public Parking(Car[] car, int itn, String name, boolean open) {
        this.car = car;
        this.itn = itn;
        this.name = name;
        this.open = open;
    }

    @Override
    public String toString() {
        return "Parking{"
                + "csr=" + Arrays.toString(car)
                + ", itn=" + itn
                + ", name='" + name + '\''
                + ", open=" + open
                + '}';
    }
}
