package ru.job4j.question;

import java.util.*;
public class Analize {


    public static Info diff(Set<User> previous, Set<User> current) {

        int added = 0;
        int changed = 0;
        boolean contains;
        Map<Integer, User> map =  new HashMap<>();
        previous.forEach(user -> map.put(user.getId(), user));


        for (User user : current) {
            contains = map.containsKey(user.getId());
            if (!contains) {
                added++;
            }
            if (!map.containsValue(user) && contains) {
                changed++;
            }
            map.remove(user.getId());
        }
        return new Info(added, changed, map.size());
    }
}