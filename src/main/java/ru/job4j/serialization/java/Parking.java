package ru.job4j.serialization.java;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.StringWriter;
import java.util.Arrays;
@XmlRootElement(name = "parking")
@XmlAccessorType(XmlAccessType.FIELD)
public class Parking {

    private  Car[] car;
    @XmlAttribute
    private int itn;
    @XmlAttribute
    private  String name;
    @XmlAttribute
    private boolean open;

    public Parking() {
    }
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


    public static void main(String[] args) throws JAXBException {

        Car[] cars = new Car[3];
        cars[0] = new Car("Tayota", "AD233434");
        cars[1] = new Car("Mazda", "AP237887");
        cars[2] = new Car("BYD", "TF88980");
        final Parking parking = new Parking(cars, 68967670, "New Parking", true);


        JAXBContext context = JAXBContext.newInstance(Parking.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(parking, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
