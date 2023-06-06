package ru.job4j.io;

import java.io.FileOutputStream;

public class Multiple {
    public static void main(String[] args) {
        String ln = System.lineSeparator();
        try (FileOutputStream out = new FileOutputStream("data/datamultiple.txt")) {
            out.write(("1 * 2 = 2" + ln
                    + "1 * 3 = 3" + ln
                    + "1 * 4 = 4" + ln
                    + "1 * 5 = 5" + ln
                    + "1 * 6 = 6" + ln
                    + "1 * 7 = 7" + ln
                    + "1 * 8 = 8" + ln
                    + "1 * 9 = 9").getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
