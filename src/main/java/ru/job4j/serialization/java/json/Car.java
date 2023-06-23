package ru.job4j.serialization.java.json;

public class Car {
    private String model;
    private String number;

    public Car() {
    }

    public Car(String model, String number) {
        this.model = model;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", serialNumber=" + number
                + '}';
    }
}
