package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (!line.isEmpty() && !line.startsWith("#")) {
                    String[] lineArr = line.split("=");
                    if (lineArr.length < 2 || lineArr[0].isBlank()) {
                        throw new IllegalArgumentException(line + " Error");
                    }
                    if (lineArr.length == 2) {
                        values.put(lineArr[0], lineArr[1]);
                    }
                    if (lineArr.length == 2 && "=".equals(line.substring(line.length() - 1))) {
                        values.put(lineArr[0], lineArr[1] + "=1");
                    }
                    if (lineArr.length == 3) {
                        values.put(lineArr[0], lineArr[1] + "=" + lineArr[2]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String value(String key) {
        return values.getOrDefault(key, " not found");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        Config a = new Config("data/app.properties");
        a.load();
        System.out.println(a.value("hibernate.connection.driver_class"));
    }

}