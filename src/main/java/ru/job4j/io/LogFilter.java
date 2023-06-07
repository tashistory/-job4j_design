package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class LogFilter {
    @SuppressWarnings("checkstyle:NeedBraces")
    public List<String> filter(String file) {
        List<String> rslt = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            in.lines().forEach(el -> {
                        if (el.contains("404 ")) {
                            rslt.add(el);
                        }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rslt;
    }

    public static void main(String[] args) {
        LogFilter logFilter = new LogFilter();
        List<String> log = logFilter.filter("data/log.txt");
        log.forEach(System.out::println);
    }
}