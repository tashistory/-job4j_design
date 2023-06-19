package ru.job4j.io;

import java.io.*;
import java.util.*;

public class ConsoleChat {
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";
    private final String path;
    private final String botAnswers;

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    private void validate(String botAnswers) {
        File answers = new File(botAnswers);
        if (!answers.exists()) {
            throw new IllegalArgumentException(String.format("Такого пути не существует \"%s\"", botAnswers));
        }
        if (!answers.isFile()) {
            throw new IllegalArgumentException(String.format("Это не файл %s", answers.getAbsoluteFile()));
        }
    }

    private String getRandomPhrases(List<String> phrathers) {
        Random random = new Random();
        int randomIndex = random.nextInt(phrathers.size());
        return phrathers.get(randomIndex);
    }

    public void run() {
        validate(botAnswers);
        List<String> log = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String userPhrather = in.nextLine();
        log.add(userPhrather);
        boolean contin = true;
        while (!OUT.equals(userPhrather)) {
            if (STOP.equals(userPhrather)) {
                contin = false;
            }
            if (CONTINUE.equals(userPhrather)) {
                contin = true;
            }
            if (contin) {
                String ansv = getRandomPhrases(readPhrases());
                System.out.println(ansv);
                log.add(ansv);
            }
            userPhrather = in.nextLine();
            log.add(userPhrather);
        }
        in.close();
        saveLog(log);

    }

    private List<String> readPhrases() {
        List<String> result = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(botAnswers))) {
            read.lines().forEach(result::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    private void saveLog(List<String> log) {
        try (PrintStream stream = new PrintStream(new FileOutputStream(path))) {
            log.forEach(stream::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("log.txt", "ansver.txt");
        cc.run();
    }
}
