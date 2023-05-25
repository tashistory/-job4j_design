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
        int index = genIndex(key);
        System.out.println("---" + table.length);
        System.out.println(index);
        boolean rsl = table[index] == null;
        if (count / capacity >= LOAD_FACTOR) {
            expand();
        }
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
        return hash & (table.length - 1);
    }
    private int genIndex(K key) {
        return key == null ? 0 : indexFor(hash(key.hashCode()));
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
         if (table[index]  == null) {
              return null;
          }
          if (table[index].key != null && table[index].key.equals(key)) {
              return table[index].value;
          }
          if (table[index].key == null && table[index].value != null) {
              return table[index].value;
          }
          return null;
        //return table[index].key != null && table[index].key.equals(key) ? table[index].value : null;
             /* return table[index]  != null
                && (table[index].key == null || (table[index].key != null
                || table[index].key.equals(key))) ? table[index].value : null; */
    }

    @Override
    public boolean remove(K key) {
        int index = genIndex(key);
        boolean rsl = table[index]  != null
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
        final int expectedModCount = modCount;
        return new Iterator<K>() {
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                boolean rsl = false;
                    while (point < count + 2) {
                        if (table[point] == null) {
                            point++;
                        } else {
                            return true;
                        }
                    }

                return rsl;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                //System.out.println(table[point].key);
               K rsl =  table[point].key;
               point++;
               return rsl;
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

    public static void main(String[] args) {
        SimpleMap<Integer, String> map = new SimpleMap<>();
        map.put(1, "1");
        map.put(2, "2");
        map.put(3, "3");
        map.put(4, "4");
        map.put(16, "16");
        //
       // map.put(0, "0");
        map.put(null, "0000");
        System.out.println("---------");
        System.out.println(map.get(16));
    }
}