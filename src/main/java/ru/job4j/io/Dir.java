package ru.job4j.io;

import java.io.File;

public class Dir {

    static void validation(String[] arg) {
        if (arg.length < 1) {
            throw new IllegalArgumentException("Недостаточно введённых параметров");
        }
    }
    public static void main(String[] args) {
        validation(args);
        File file = new File(args[0]);

        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }
        System.out.println(String.format("size : %s", file.getTotalSpace()));
        System.out.println("File name\t\t\t\t\tSize");
        for (File subfile : file.listFiles()) {
            if (subfile.isFile() && subfile.getName().contains(args[1])) {
                System.out.println(String.format("%s\t%s", subfile.getName(), subfile.length()));
            }
        }
    }
}

