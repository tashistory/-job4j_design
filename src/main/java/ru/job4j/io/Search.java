package ru.job4j.io;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    static void validation(String[] arg) {
        if (arg.length < 2) {
            throw new IllegalArgumentException("Недостаточно введённых параметров");
        }
        File dir = new File(arg[0]);
        if (!dir.exists()) {
            throw new IllegalArgumentException(String.format("Такого пути не существует \"%s\"", arg[0]));
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(String.format("Это не дериктория %s", dir.getAbsoluteFile()));
        }

        if (!arg[1].startsWith(".") || arg[1].length() < 2) {
            throw new IllegalArgumentException(String.format("Расширение фала не верное \"%s\"", arg[1]));
        }

    }
    public static void main(String[] args) throws IOException {
        validation(args);
        Path start = Paths.get(args[0]);
       search(start, p -> p.toFile().getName().endsWith(args[1])).forEach(System.out::println);
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}