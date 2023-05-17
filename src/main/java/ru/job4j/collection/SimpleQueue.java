package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int countIn = 0;
    private int countOut = 0;

    public T poll() {
        if (countIn == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        while (countOut != countIn - 1) {
            out.push(in.pop());
            countOut++;
        }
        T result = in.pop();
        countIn = 0;
        while (countOut != 0) {
            in.push(out.pop());
            countOut--;
            countIn++;
        }
        return result;
    }

    public void push(T value) {
        in.push(value);
        countIn++;
    }
}