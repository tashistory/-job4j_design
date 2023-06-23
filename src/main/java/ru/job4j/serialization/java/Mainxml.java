package ru.job4j.serialization.java;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class Mainxml {
    public static void main(String[] args) throws JAXBException, IOException {
        Car[] cars = new Car[3];
        cars[0] = new Car("Tayota", "AD233434");
        cars[1] = new Car("Mazda", "AP237887");
        cars[2] = new Car("BYD", "TF88980");
        Parking parking = new Parking(cars, 68967670, "New Parking", true);
        JAXBContext context = JAXBContext.newInstance(Parking.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(parking, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Parking result = (Parking) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}
