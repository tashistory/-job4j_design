package ru.job4j.hashcode;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class PrivateOwner {
   private String name;
    private String surname;
    private LocalDate birthDay;
    private String pasSeries;
    private int pasNumber;
    private ArrayList<Property> properties;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PrivateOwner myOwner = (PrivateOwner) o;
        return pasNumber == myOwner.pasNumber && Objects.equals(name, myOwner.name) && Objects.equals(surname, myOwner.surname) && Objects.equals(birthDay, myOwner.birthDay) && Objects.equals(pasSeries, myOwner.pasSeries) && Objects.equals(properties, myOwner.properties);
    }
    private int hashCode;
    @Override
    public int hashCode() {
        int result = hashCode;
        if (result == 0) {
            result = 31 * Objects.hash(name);
            result = result + 31 * Objects.hash(surname);
            result = result + 31 * Objects.hash(birthDay);
            result = result + 31 * Objects.hash(pasSeries);
            result = result + 31 * Integer.hashCode(pasNumber);
            result = result + properties.stream()
                    .map(el -> 31 * Objects.hashCode(el.address) + 31 * Objects.hashCode(el.houseNumber))
                    .reduce(Integer::sum).orElse(0);
        }
        return result;
    }

    public class Property {
       private String address;
       private int houseNumber;

        public Property(String address, int houseNumber) {
            this.address = address;
            this.houseNumber = houseNumber;
        }

        public String getAddress() {
            return address;
        }

        public int getHouseNumber() {
            return houseNumber;
        }
    }


}
