package ru.job4j.io;

import java.io.*;
import java.nio.file.Paths;
import java.util.*;

public class CSVReader {
    private static void check(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Такого пути не существует \"%s\"", path));
        }
        if (!file.isFile()) {
            throw new IllegalArgumentException(String.format("Это не файл %s", path));
        }
    }

    public static void handle(ArgsName argsName) {
        String path = argsName.get("path");
        check(path);
        String delimiter = argsName.get("delimiter");
        String out = argsName.get("out");
        List<String> filter = Arrays.asList(argsName.get("filter").split("\\s*,\\s*"));
        List<ArrayList<String>> arrCSV = new ArrayList();
        try (Scanner scanner = new Scanner(Paths.get(path))) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                var scanner2 = new Scanner(new ByteArrayInputStream(s.replace("\"", "").
                        replace(System.lineSeparator(), "").getBytes())).useDelimiter(delimiter);
                ArrayList<String> arr1 = new ArrayList<>();
                while (scanner2.hasNext()) {
                    String s2 = scanner2.next();
                    arr1.add(s2.replace(",", ""));
                }
                arrCSV.add(arr1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        conclusion(filter, arrCSV, delimiter, out);
    }

    private static void conclusion(List<String> filter, List<ArrayList<String>> arrCSV, String delimiter, String out) {
        List<Integer> numberClum = new ArrayList<>();
        filter.forEach(e -> numberClum.add(arrCSV.get(0).indexOf(e)));
        List<String> outList = new ArrayList<>();
        for (ArrayList<String> el : arrCSV) {
            String line = "";
            for (int num : numberClum) {
                line = numberClum.indexOf(num) == numberClum.size() - 1 ? line + el.get(num) : line + el.get(num) + delimiter;
            }
            outList.add(line);
        }
        if (out.equals("stdout")) {
            outList.forEach(System.out::println);
        } else {
            try (PrintStream stream = new PrintStream(new FileOutputStream(out))) {
                outList.forEach(stream::println);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        if (args.length < 4) {
            throw new IllegalArgumentException("Недостаточно введённых параметров");
        }
        ArgsName argsName = ArgsName.of(args);
        handle(argsName);
    }
}
