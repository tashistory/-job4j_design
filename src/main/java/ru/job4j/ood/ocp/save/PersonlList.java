package ru.job4j.ood.ocp.save;

import java.util.List;

public class PersonlList {
    String typeSave;
    List<Person> persons;

    public PersonlList(List<Person> persons, String typeSave) {

        this.persons = persons;
        this.typeSave = typeSave;

    }

    public void save() {
        if ("file".equals(typeSave)) {
            SaveInFiles.save(this.persons);
        } else if ("bd".equals(typeSave)) {
            SaveInBD.save(this.persons);
        }
    }
}
