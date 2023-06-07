package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("data/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                boolean rslt = Integer.parseInt(line) % 2 == 0;
                System.out.println(line + " - " + rslt);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}