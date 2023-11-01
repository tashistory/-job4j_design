package ru.job4j.ood.lsp.parking;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import static org.assertj.core.api.Assertions.*;
@Disabled
class ParkingTest {
    @Test
    public void whenOnePassengerCar() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:SS");
        Car passengerCar = new PassengerCar("10AB3433TR");
        Parking passengerParking = new PassengerParking(10);
        Parking cargoParking = new CargoParking(20);
        ControlParking control = new ControlParking(new ArrayList<Parking>(Arrays.asList(passengerParking, cargoParking)));
        control.park(passengerCar, new Date());
        assertThat(passengerParking.findByPlace(0).equals(passengerCar));
    }

    @Test
    public void whenOneCargoCar() throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:SS");
        Car cargoCar = new CargoCar("10AB3433TR", 3);
        Parking passengerParking = new PassengerParking(10);
        Parking cargoParking = new CargoParking(20);
        ControlParking control = new ControlParking(new ArrayList<>(Arrays.asList(passengerParking, cargoParking)));
        control.park(cargoCar, new Date());
        assertThat(cargoParking.findByPlace(0).equals(cargoCar));
    }

    @Test
    public void whenLastCargoCar() throws ParseException {
        Car passengerCar1 = new PassengerCar("10AB4546UY");
        Car passengerCar2 = new PassengerCar("10AB333UY");
        Car passengerCar3 = new PassengerCar("10AB555UY");
        Car cargoCar1 = new CargoCar("10AB3433TR", 2);
        Car cargoCar2 = new CargoCar("11AB3563TR", 2);
        Parking passengerParking = new PassengerParking(10);
        Parking cargoParking = new CargoParking(1);
        ControlParking control = new ControlParking(new ArrayList<>(Arrays.asList(passengerParking, cargoParking)));
        control.park(passengerCar1, new Date());
        control.park(passengerCar2, new Date());
        control.park(passengerCar3, new Date());
        passengerParking.exit("10AB333UY");
        control.park(cargoCar1, new Date());
        control.park(cargoCar2, new Date());
        assertThat(passengerParking.findByPlace(3).equals(cargoCar2));
    }

}