package ru.job4j.serialization.java;

public class Car {
   private final String model;
   private final String number;

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
