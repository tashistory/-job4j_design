package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {
    static int added = 0;
    static int changed = 0;

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> map = previous.stream()
                .collect(Collectors.toMap(User::getId, user -> user,
                        (existing, replacement) -> existing));

        current.forEach(user -> {
            if (!map.containsKey(user.getId())) {
                added++;
            }
            if (!map.containsValue(user) && map.containsKey(user.getId())) {
                changed++;
            }
            map.remove(user.getId());
        });
        Info rsl = new Info(added, changed, map.size());
        added = 0;
        changed = 0;
        return rsl;
    }
}