package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
        }
        int index = genIndex(key);
        boolean rsl = table[index] == null;
        if (rsl) {
            table[index] = new MapEntry<>(key, value);
            modCount++;
            count++;
        }
        return rsl;
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private int genIndex(K key) {
        return Objects.nonNull(key) ? indexFor(hash(key.hashCode())) : 0;
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] extendTable = new MapEntry[capacity];
        for (MapEntry<K, V> e : table) {
            if (e != null) {
                extendTable[genIndex(e.key)] = e;
            }
        }
        table = extendTable;
    }

    @Override
    public V get(K key) {
        int index = genIndex(key);
        return ((table[index] != null)
                && ((table[index].key != null
                && table[index].key.equals(key))
                || (table[index].key == null
                && table[index].key == key)))
                ? table[index].value : null;
    }

    @Override
    public boolean remove(K key) {
        int index = genIndex(key);
        boolean rsl = table[index] != null
                && (table[index].key == null
                || (table[index].key != null
                && table[index].key.equals(key)));
        if (rsl) {
            table[index].value = null;
            table[index].key = null;
            table[index] = null;
            modCount++;
            count--;
        }
        return rsl;
    }

    @Override
    public Iterator<K> iterator() {

        return new Iterator<K>() {
            final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean rsl = false;
                while (point < table.length) {
                    if (table[point] == null) {
                        point++;
                    } else {
                        return true;
                    }
                }
                return rsl;
               /* return point < count;
                return point < table.length; */
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}