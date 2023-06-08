package ru.job4j.io;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Analysis {
    public void unavailable(String source, String target) {
        boolean condition;
        int conditionprev = 500;
        // StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            for (String line = read.readLine(); line != null; line = read.readLine()) {
             /*  if ((line.startsWith("400") || line.startsWith("500")) && ){
                   condition = true;
               }*/
                System.out.println(line + " " + (line.startsWith("400") || line.startsWith("500")));

                //String[] lineArr = line.split(" ");
                //condition = line.startsWith("400") || line.startsWith("500");
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