package ru.job4j.serialization.java.json;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private List<Car> car = new ArrayList<>();

    private int itn;

    private  String name;

    private boolean open;

    public Parking() {
    }
    public Parking(List<Car> car, int itn, String name, boolean open) {
        this.car = car;
        this.itn = itn;
        this.name = name;
        this.open = open;
    }

    public List<Car> getCar() {
        return new ArrayList<Car>(car);
    }

    public int getItn() {
        return itn;
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    @Override
    public String toString() {
        return "Parking{"
                + "car=" + car
                + ", itn=" + itn
                + ", name='" + name + '\''
                + ", open=" + open
                + '}';
    }
}
