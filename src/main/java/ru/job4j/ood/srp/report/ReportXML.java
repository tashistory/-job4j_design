package ru.job4j.ood.srp.report;

import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.function.Predicate;


public class ReportXML implements Report {
    private final Store store;
    private final JAXBContext context;

    public ReportXML(Store store, JAXBContext context) {
        this.store = store;
        this.context = context;
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(store, writer);
            xml = writer.getBuffer().toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }


    public static void main(String[] args) throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Stepan", now, now, 90);
        Employee worker3 = new Employee("Alex", now, now, 120);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportXML(store, JAXBContext.newInstance(MemStore.class));
        System.out.println(engine.generate(em -> true));
    }
}
