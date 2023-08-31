package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;


public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        StringBuilder text = new StringBuilder();
        System.out.println();
        try (BufferedReader in = new BufferedReader(new FileReader(String.format("%s\\%s", cachingDir, key)))) {
            in.lines().forEach(text::append);
        } catch (Exception e) {
            e.printStackTrace();
        }
        put(key, text.toString());
        return text.toString();
    }
}