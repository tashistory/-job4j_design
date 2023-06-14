package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private Set<String> files = new HashSet<>();
    private Map<FileProperty, String> tmps = new HashMap<>();


    void printDublicate() {
        files.forEach(System.out::println);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty tmpfile = new FileProperty(attrs.size(), file.toFile().getName());
        String tmpsorce = file.toFile().getAbsolutePath();
        if (tmps.containsKey(tmpfile)) {
            files.add(tmps.put(tmpfile, tmpsorce));
            files.add(tmpsorce);
        }
        tmps.put(tmpfile, tmpsorce);
        return super.visitFile(file, attrs);
    }
}