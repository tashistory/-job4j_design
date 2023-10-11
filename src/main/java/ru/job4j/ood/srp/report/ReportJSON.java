package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;
import ru.job4j.ood.srp.store.Store;

import javax.xml.bind.JAXBException;
import java.util.Calendar;
import java.util.function.Predicate;

public class ReportJSON implements Report {
    private final Store store;
    private final Gson context;
    public ReportJSON(Store store, Gson context) {
        this.store = store;
        this.context = context;
    }
    @Override
    public String generate(Predicate<Employee> filter) {
        return context.toJson(store);
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
        Report engine = new ReportJSON(store, new GsonBuilder().create());
        System.out.println(engine.generate(em -> true));
    }

}
