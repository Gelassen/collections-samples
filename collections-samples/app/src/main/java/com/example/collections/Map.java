package com.example.collections;

import java.util.Collection;

/**
 * Created by John on 7/13/2016.
 */
public interface Map<K, V> {

    V get(Object key);
    V put(K key, V value);
    int size();
    Collection<V> values();
}
