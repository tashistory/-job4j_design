package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements LinkedList<E> {

    private int size = 0;
    private int modCount = 0;
    private Node<E> head;

    @Override
    public void add(E value) {
        Node<E> l = head;
        final Node<E> newNode = new Node<>(value, null);
        if (head == null) {
            head = newNode;
        } else {
            while (l.next != null) {
                l = l.next;
            }
            l.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> n = head;
        for (int i = 0; i < index; i++) {
            n = n.next;
        }
        return n.item;
    }

    @Override
    public Iterator<E> iterator() {
        final int expectedModCount = modCount;
        return new Iterator<E>() {
            private int point = 0;
            Node<E> l;
            Node<E> n = head;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return n != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                point++;
                l = n;
                n = n.next;
                return l.item;
            }
        };
    }

    private static class Node<E> {
        private E item;
        private Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}