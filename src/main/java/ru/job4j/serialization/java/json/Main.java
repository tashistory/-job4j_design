package ru.job4j.serialization.java.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Tayota", "AD233434"));
        cars.add(new Car("Mazda", "AP237887"));
        cars.add(new Car("BYD", "TF88980"));
        Parking parking = new Parking(cars, 68967670, "New Parking", true);
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonCars = new JSONArray(new ArrayList<>(parking.getCar()));
        jsonObject.put("cars", jsonCars);
        jsonObject.put("itn", parking.getItn());
        jsonObject.put("name", parking.getName());
        jsonObject.put("open", parking.isOpen());

        System.out.println(jsonObject.toString());
        System.out.println(new JSONObject(parking).toString());

    }
}
