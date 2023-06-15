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
    public void getZip(String[] args)throws IOException {
        ArgsName argumets = ArgsName.of(args);
        String directory = argumets.get("d");
        String exclude = argumets.get("e");
        String output = argumets.get("o");
        Search.validation(new String[]{directory, exclude});
        Path start = Paths.get(directory);
        List<Path> path = Search.search(start, p -> !p.toFile().getName().endsWith(exclude));
        packFiles(path, new File(output));
    }

    public static void main(String[] args) throws IOException {
        Zip zip = new Zip();
        zip.getZip(args);
    }
}