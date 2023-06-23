package ru.job4j.serialization.java;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {
    public static void main(String[] args) {
        Car[] cars = new Car[3];
        cars[0] = new Car("Tayota", "AD233434");
        cars[1] = new Car("Mazda", "AP237887");
        cars[2] = new Car("BYD", "TF88980");
        Parking parking = new Parking(cars, 68967670, "New Parking", true);
        final Gson gson = new GsonBuilder().create();
        String jsonString =  gson.toJson(parking);
        System.out.println(jsonString);
        System.out.println("_________________________________________________");

        final Parking restoreParking  = gson.fromJson(jsonString, Parking.class);
        System.out.println(restoreParking);
    }
}
