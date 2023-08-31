package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

public abstract class AbstractCache<K, V> {

    private final Map<K, SoftReference<V>> cache = new HashMap<>();

    public final void put(K key, V value) {
        SoftReference<V> softReferenceValue = new SoftReference<>(value);
        cache.put(key, softReferenceValue);
    }

    public final V get(K key) {
        V value = null;
        SoftReference<V> valueSoft = cache.get(key);
        if (valueSoft != null) {
            System.out.println("Из кэша");
            value = valueSoft.get();
        }
        if (value == null) {
            value = load(key);
        }
        return value;
        /*return value = cache.get(key).get() == null ? load(key) : value; */
    }

    protected abstract V load(K key);
}