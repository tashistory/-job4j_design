package ru.job4j.io;

import java.io.*;
import java.util.*;

public class Analysis {
    public void unavailable(String source, String target) {

        StringJoiner out = new StringJoiner("");
        List<String>  arr = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            read.lines().forEach(arr::add);
            int k = 0;
            for (int i = 0; i < arr.size() - 1; i++) {
               if (arr.get(i).contains("400") ||  arr.get(i).contains("500")) {
                   k++;
                   if (k == 1) {
                       out.add(arr.get(i).split(" ")[1]);
                   }
                   if (arr.get(i + 1).contains("200") ||  arr.get(i + 1).contains("300")) {
                       out.add(";" + arr.get(i + 1).split(" ")[1] + ";" + System.lineSeparator());
                       k = 0;
                   }
               }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileOutputStream tar = new FileOutputStream(target)) {
            tar.write(out.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void main(String[] args) {
        Analysis analysis = new Analysis();
        analysis.unavailable("data/server.log", "data/target.csv");
    }
}