package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            boolean flag = false;
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (line.startsWith("400") || line.startsWith("500")) {
                    if (!flag) {
                        out.printf("%s;", line.split(" ")[1]);
                        flag = true;
                    }
                } else {
                    if (flag) {
                        out.printf("%s;%s", line.split(" ")[1], System.lineSeparator());
                        flag = false;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}