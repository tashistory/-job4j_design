package ru.job4j.ood.srp.store;

import ru.job4j.ood.srp.model.Employee;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.function.Predicate;

@XmlRootElement(name = "employees")
@XmlAccessorType(XmlAccessType.FIELD)
public interface Store {
    void add(Employee em);

    List<Employee> findBy(Predicate<Employee> filter);
}