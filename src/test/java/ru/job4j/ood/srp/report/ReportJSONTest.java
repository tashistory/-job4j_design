package ru.job4j.ood.srp.report;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBException;

import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.assertj.core.api.Assertions.*;

class ReportJSONTest {
    @Test
    public void whenAccountingGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        Employee worker2 = new Employee("Stepan", now, now, 90);
        Employee worker3 = new Employee("Alex", now, now, 120);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        DateTimeParser dateTimeParser = new ReportDateTimeParser();
        Gson gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(GregorianCalendar.class, new ReportJSON.CalendarSerializer(dateTimeParser))
                .create();
        Report engine = new ReportJSON(store, gson);
        String otv = engine.generate(em -> true);

        StringBuilder expect = new StringBuilder()
                .append("{\"employees\": [");
        for (Employee em : store.findBy(sr -> true)) {
            expect.append("{")
                    .append("\"name\": ").append("\"").append(em.getName()).append("\",")
                    .append("\"hired\": ").append("\"").append(dateTimeParser.parse(em.getHired())).append("\",")
                    .append("\"fired\": ").append("\"").append(dateTimeParser.parse(em.getFired())).append("\",")
                    .append("\"salary\": ").append(em.getSalary())
                    .append("},");
        }
        expect.append("] }");
        assertThat(otv.replaceAll(" ", "").replace(",", "").replaceAll("\n", "")).isEqualTo(expect.toString().replaceAll(" ", "").replaceAll(",", ""));
    }
}