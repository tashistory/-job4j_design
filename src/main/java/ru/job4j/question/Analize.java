package ru.job4j.question;

import java.util.*;
import java.util.stream.Collectors;

public class Analize {
    static long added;
    static long changed;
    static long deleted;

    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, User> map = previous.stream()
                .collect(Collectors.toMap(User::getId, user -> user,
                        (existing, replacement) -> existing));

       added = current.stream().filter(user -> !map.containsKey(user.getId())).count();
       changed = current.stream().filter(user -> !map.containsValue(user) && map.containsKey(user.getId())).count();
       current.forEach(user -> map.remove(user.getId()));
        return new Info((int) added, (int) changed, map.size());
    }
}