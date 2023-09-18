package ru.job4j.kiss.fool;

import java.util.Scanner;

public class Fool {
    public static String opponent(int startAt) {
        String ressult;
        if (startAt % 3 == 0 && startAt % 5 == 0) {
            ressult = "FizzBuzz";
        } else if (startAt % 3 == 0) {
            ressult = "Fizz";
        } else if (startAt % 5 == 0) {
            ressult = "Buzz";
        } else {
            ressult = Integer.toString(startAt);
        }
        return ressult;
    }

    public static int player(int startAt, String answer) {
        if (!opponent(startAt).equals(answer)) {
            System.out.println("Ошибка. Начинай снова.");
            return 0;
        }
        return startAt;
    }

    public static void main(String[] args) {
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var io = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(opponent(startAt));
            startAt++;
            var answer = io.nextLine();
            startAt = player(startAt, answer);
            startAt++;
        }
    }
}