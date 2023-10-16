package ru.job4j.ood.srp.report;
import ru.job4j.ood.srp.formatter.DateTimeParser;
import ru.job4j.ood.srp.model.Employee;
import ru.job4j.ood.srp.store.Store;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;


public class ReportXML implements Report {
    private final Store store;
    private final DateTimeParser<Calendar> dateTimeParser;
    private final JAXBContext context;

    public ReportXML(Store store, DateTimeParser<Calendar> dateTimeParser, JAXBContext context) {
        this.store = store;
        this.dateTimeParser = dateTimeParser;
        this.context = context;
    }

    @XmlRootElement(name = "employees")
    public static class Employees {

        private List<XMLEmployee> employee;

        public Employees() {

        }

        public Employees(List<XMLEmployee> employee) {
            this.employee = employee;
        }

        public List<XMLEmployee> getEmployee() {
            return employee;
        }

        public void setEmployee(List<XMLEmployee> employee) {
            this.employee = employee;
        }
    }

    public static class XMLEmployee {
        private String name;
        private String hired;
        private String fired;
        private double salary;

        public XMLEmployee(String name, String hired, String fired, double salary) {
            this.name = name;
            this.hired = hired;
            this.fired = fired;
            this.salary = salary;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getHired() {
            return hired;
        }

        public void setHired(String hired) {
            this.hired = hired;
        }

        public String getFired() {
            return fired;
        }

        public void setFired(String fired) {
            this.fired = fired;
        }

        public double getSalary() {
            return salary;
        }

        public void setSalary(double salary) {
            this.salary = salary;
        }
    }

    @Override
    public String generate(Predicate<Employee> filter) throws JAXBException {
        List<XMLEmployee> xmlEmployees = new ArrayList<>();
        for (Employee emp : store.findBy(filter)) {
            xmlEmployees.add(new XMLEmployee(emp.getName(), dateTimeParser.parse(emp.getHired()), dateTimeParser.parse(emp.getFired()), emp.getSalary()));
        }
        Employees employees = new Employees(xmlEmployees);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(employees, writer);
            xml = writer.getBuffer().toString();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return xml;
    }
}
