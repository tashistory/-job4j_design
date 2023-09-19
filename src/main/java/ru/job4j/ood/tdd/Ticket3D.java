package ru.job4j.ood.tdd;

import java.util.Calendar;
import java.util.Objects;

public class Ticket3D implements Ticket {
    Account account;
    int row;
    int column;
    Calendar date;

    public Ticket3D() {
    }
    public Ticket3D(Account account, int row, int column, Calendar date) {
        this.account = account;
        this.row = row;
        this.column = column;
        this.date = date;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Ticket3D ticket3D = (Ticket3D) o;

        if (row != ticket3D.row) {
            return false;
        }
        if (column != ticket3D.column) {
            return false;
        }
        if (!Objects.equals(account, ticket3D.account)) {
            return false;
        }
        return Objects.equals(date, ticket3D.date);
    }

    @Override
    public int hashCode() {
        int result = account != null ? account.hashCode() : 0;
        result = 31 * result + row;
        result = 31 * result + column;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }
}
