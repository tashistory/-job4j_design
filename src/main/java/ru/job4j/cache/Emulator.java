package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь");
        String text = scanner.nextLine();
        DirFileCache  file = new DirFileCache(text);

        while (true) {
            System.out.println("Введите имя файла");
             text = scanner.nextLine();
             System.out.println(file.get(text));
        }

    }
}
