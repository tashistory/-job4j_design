package ru.job4j.search;

import ru.job4j.io.ArgsName;
import ru.job4j.io.SearchFiles;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.regex.Pattern;

public class Main {
    private void checks(ArgsName args) {
        String type = args.get("t");
        String output = args.get("o");
        File dir = new File(args.get("d"));
        if (!dir.exists()) {
            throw new IllegalArgumentException(String.format("Такого пути не существует \"%s\"", dir.getName()));
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(String.format("Это не дериктория %s", dir.getAbsoluteFile()));
        }

        if (!"mask".equals(type) && !"name".equals(type) && !"regex".equals(type)) {
            throw new IllegalArgumentException(String.format("Тип поиска\"%s\" не верное", type));
        }
        if (!output.endsWith(".txt") || output.length() < 5) {
            throw new IllegalArgumentException(String.format("Имя архива не верное \"%s\"", output));
        }
    }

    public static void main(String[] args) throws IOException {

        ArgsName argumets = ArgsName.of(args);
        Main find = new Main();
        find.checks(argumets);
        Path start = Paths.get(argumets.get("d"));
        List<Path> founds = new ArrayList<>();
        if ("name".equals(argumets.get("t"))) {
            founds.addAll(search(start, p -> p.toFile().getName().equals(argumets.get("n"))));
        }
        if ("mask".equals(argumets.get("t"))) {
            String reg = argumets.get("n")
                    .replace(".", "[.]")
                    .replace("*", ".+")
                    .replace("?", ".");
            Pattern pattern = Pattern.compile(reg);
            founds.addAll(search(start, p -> pattern.matcher(p.toFile().getName()).find()));
        }
        if ("regex".equals(argumets.get("t"))) {
            Pattern pattern = Pattern.compile(argumets.get("n"));
            founds.addAll(search(start, p -> pattern.matcher(p.toFile().getName()).find()));
        }
        out(founds, argumets.get("o"));

    }


    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }

    public static void out(List<Path> founds, String file) {

        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            founds.forEach(out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
