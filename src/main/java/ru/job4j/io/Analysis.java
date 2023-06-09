package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            boolean flag = true;
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if (((line.startsWith("400") || line.startsWith("500"))  == flag)) {
                    out.append("%s;".formatted(line.split(" ")[1]))
                            .append(flag ? "" : System.lineSeparator());
                    flag = !flag;
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