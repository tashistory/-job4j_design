package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {


    public static Info diff(Set<User> previous, Set<User> current) {

        int added = 0;
        int changed = 0;
        Map<Integer, User> map = previous.stream()
                .collect(Collectors.toMap(User::getId, user -> user,
                        (existing, replacement) -> existing));


        for (User user : current) {
            if (!map.containsKey(user.getId())) {
                added++;
            }
            if (!map.containsValue(user) && map.containsKey(user.getId())) {
                changed++;
            }
            map.remove(user.getId());
        }
        return new Info(added, changed, map.size());
    }
}