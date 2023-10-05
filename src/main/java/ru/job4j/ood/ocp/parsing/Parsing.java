package ru.job4j.ood.ocp.parsing;

import java.nio.file.Path;

public class Parsing {
    Path path;
    String text;
    void openFile(String path) {
        System.out.println("Файл открыт");

    };

    void redFile() {
        System.out.println("Файл считан");
    }

    void analiseText() {
        System.out.println("Текст Обработан");
    }

    void save() {
        System.out.println("Сохранён");
    }

}
