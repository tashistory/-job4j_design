package ru.job4j.io;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.function.Predicate;

public class Search {
    static void validation(String[] arg) {
        if (arg.length < 1) {
            throw new IllegalArgumentException("Недостаточно введённых параметров");
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