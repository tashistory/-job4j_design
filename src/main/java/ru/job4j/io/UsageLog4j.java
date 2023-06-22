package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Petr Arsentev";
        int age = 33;
        char sex = 'М';
        float height = 175.4f;
        short schoolNumber = 1234;
        byte houseNumber = 54;
        boolean married = true;
        double amountAccount = 3445454565465654575676788.44D;
        long numberLikes = 24245554465L;
        LOG.debug("User info name : {}, age : {}, sex : {}, height : {}, schoolNumber : {}, "
                        + "houseNumber : {}, married : {}, amountAccount : {}, numberLikes : {}",
                name, age, sex, height, schoolNumber, houseNumber, married, amountAccount, numberLikes);
    }
}