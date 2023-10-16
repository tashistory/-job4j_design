package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.formatter.ReportDateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportXMLTest {
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
        DateTimeParser<Calendar> dateTimeParser = new ReportDateTimeParser();
        Report engine = new ReportXML(store, dateTimeParser, JAXBContext.newInstance(ReportXML.Employees.class));
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("<employees>");
        for (Employee em : store.findBy(sr -> true)){
            expect.append("<employee>")
                    .append("<fired>").append(dateTimeParser.parse(em.getFired())).append("</fired>")
                    .append("<hired>").append(dateTimeParser.parse(em.getHired())).append("</hired>")
                    .append("<name>").append(em.getName()).append("</name>")
                    .append("<salary>").append(em.getSalary()).append("</salary>")
                    .append("</employee>");
        }
        expect.append("</employees>");
        String otv = engine.generate(em -> true);
        assertThat(otv.replaceAll(" ", "").replaceAll("\n", "")).isEqualTo(expect.toString().replaceAll(" ", ""));
    }

}