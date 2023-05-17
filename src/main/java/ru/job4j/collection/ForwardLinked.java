package ru.job4j.collection;

import java.util.*;

public class ForwardLinked<T> implements Iterable<T> {

    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        Node<T> link = head;
        final Node<T> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            while (link.next != null) {
                link = link.next;
            }
            link.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> next = head;
        for (int i = 0; i < index; i++) {
            next = next.next;
        }
        return next.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> tempHead = head.next;
        Node<T> tempNode = new Node<>(head.item, head.next);
        head = new Node<>(null, null);
        head = tempHead;
        size--;
        modCount++;
        return tempNode.item;
    }

    public void addFirst(T value) {
        Node<T> link = head;
        head = head == null ? new Node<>(value, null) : new Node<>(value, link);
        size++;
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        final int expectedModCount = modCount;
        return new Iterator<T>() {
            Node<T> link;
            Node<T> next = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return next != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                link = next;
                next = next.next;
                return link.item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}