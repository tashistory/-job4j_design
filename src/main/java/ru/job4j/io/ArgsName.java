package ru.job4j.io;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        chekGetValue(key);
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException(String.format("This key: '%s' is missing", key));
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String arg: args) {
            String[] lineArr = arg.split("=", 2);
            values.put(lineArr[0].substring(1), lineArr[1]);
        }

    }

    private void chekGetValue(String key) {
        if (key.startsWith("-") ||  key.indexOf("=") == key.length() - 1) {
            throw new IllegalArgumentException("Invalid key");
        }
    }

    private static void checkArgs(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        for (String arg: args) {
            if (!arg.contains("=")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain an equal sign", arg));
            }
            if (!arg.startsWith("-")) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not start with a '-' character", arg));
            }
            if (arg.indexOf("=") == arg.length() - 1) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a value", arg));
            }
            if (arg.indexOf("=") == 1) {
                throw new IllegalArgumentException(String.format("Error: This argument '%s' does not contain a key", arg));
            }
        }
    }

    public static ArgsName of(String[] args) {
        checkArgs(args);
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[] {"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[] {"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}