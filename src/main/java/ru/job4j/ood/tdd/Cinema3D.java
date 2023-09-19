package ru.job4j.ood.tdd;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.function.Predicate;

public class Cinema3D implements Cinema {

    List<Session> sessions = new ArrayList<>();
    @Override
    public List<Session> find(Predicate<Session> filter) {
       return sessions.stream().filter(filter).toList();
    }

    @Override
    public Ticket buy(Account account, int row, int column, Calendar date) {
        if (row < 1 || column < 1) {
            throw new IllegalArgumentException();
        }
        return new Ticket3D(account, row,  column, date);
    }

    @Override
    public void add(Session session) {
        sessions.add(session);
    }
}
