package ru.job4j.cache;

import java.util.Scanner;

public class Emulator {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите путь");
        String text = scanner.nextLine();
        DirFileCache file = new DirFileCache(text);
        boolean run = true;
        while (run) {
            System.out.println("Введите имя файла");
            text = scanner.nextLine();
            System.out.println(file.get(text));
            System.out.println("Продолжить? Y");
            text = scanner.nextLine();
            if (!"y".equalsIgnoreCase(text)) {
                run = false;
            }
        }

    }
}
