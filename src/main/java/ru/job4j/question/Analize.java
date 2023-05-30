package ru.job4j.question;

import java.util.*;

public class Analize {


    public static Info diff(Set<User> previous, Set<User> current) {

        int added = 0;
        int changed = 0;
        int id;
        Map<Integer, User> map =  new HashMap<>();
        previous.forEach(user -> map.put(user.getId(), user));

        for (User user : current) {
            id = user.getId();
            if (!map.containsKey(id)) {
                added++;
            }
            if (!map.containsValue(user) && map.containsKey(id)) {
                changed++;
            }
            map.remove(user.getId());
        }
        return new Info(added, changed, map.size());
    }
}