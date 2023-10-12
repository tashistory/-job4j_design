package ru.job4j.ood.srp.report;

import org.junit.jupiter.api.Test;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.MemStore;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import static org.assertj.core.api.Assertions.*;

class ReportXMLTest {
    @Test
    public void whenAccountingGenerated() throws JAXBException {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportXML(store, JAXBContext.newInstance(ReportXML.Employees.class));
        String ls = System.lineSeparator();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>")
                .append("<employees>")
                .append("<employee>")
                .append("<fired>").append(dateFormat.format(worker.getFired().getTime())).append("</fired>")
                .append("<hired>").append(dateFormat.format(worker.getHired().getTime())).append("</hired>")
                .append("<name>").append(worker.getName()).append("</name>")
                .append("<salary>").append(worker.getSalary()).append("</salary>")
                .append("</employee>")
                .append("</employees>");
        String otv = engine.generate(em -> true);
        assertThat(otv.replaceAll(" ", "").replaceAll("\n", "")).isEqualTo(expect.toString().replaceAll(" ", ""));
    }

}