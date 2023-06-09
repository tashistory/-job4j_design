package ru.job4j.io;

import java.io.*;

public class Analysis {
    public void unavailable(String source, String target) {
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new BufferedOutputStream(new FileOutputStream(target)))) {
            boolean k = false;
            for (String line = read.readLine(); line != null; line = read.readLine()) {
                if ((line.startsWith("400") || line.startsWith("500")) && !k) {
                    out.print(line.split(" ")[1] + ";");
                    k = true;
                }
                if ((line.startsWith("200") || line.startsWith("300")) && k) {
                    out.print(line.split(" ")[1] + ";" + System.lineSeparator());
                    k = false;
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