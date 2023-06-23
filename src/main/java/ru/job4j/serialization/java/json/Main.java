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
        List<Car> myCar = new ArrayList<>(parking.getCar());
        JSONArray jsonCars = new JSONArray(myCar);
        jsonObject.put("cars", jsonCars);
        jsonObject.put("itn", parking.getItn());
        jsonObject.put("name", parking.getName());
        jsonObject.put("open", parking.isOpen());

        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.getJSONArray("cars"));
        System.out.println(new JSONObject(parking).toString());

    }
}
