package ru.job4j.io;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public void packFiles(List<Path> sources, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new FileOutputStream(target))) {
            for (Path source : sources) {
                zip.putNextEntry(new ZipEntry(source.toFile().getPath()));
                Files.copy(source, zip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private  void checks(ArgsName args) {
        String exclude = args.get("e");
        String output = args.get("o");
        File dir = new File(args.get("d"));
        if (!dir.exists()) {
            throw new IllegalArgumentException(String.format("Такого пути не существует \"%s\"", dir.getName()));
        }
        if (!dir.isDirectory()) {
            throw new IllegalArgumentException(String.format("Это не дериктория %s", dir.getAbsoluteFile()));
        }

        if (!exclude.startsWith(".") || exclude.length() < 2) {
            throw new IllegalArgumentException(String.format("Расширение фала не верное \"%s\"", exclude));
        }
        if (!output.endsWith(".zip") || output.length() < 5) {
            throw new IllegalArgumentException(String.format("Имя архива не верное \"%s\"", output));
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName argumets = ArgsName.of(args);
        Zip zip = new Zip();
        zip.checks(argumets);
        List<Path> path = Search.search(Paths.get(argumets.get("d")), p -> !p.toFile().getName().endsWith(argumets.get("e")));
        zip.packFiles(path, new File(argumets.get("o")));
    }
}