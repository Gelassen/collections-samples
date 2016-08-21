package com.example.collections;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by John on 7/13/2016.
 */
public class HashMap<K,V> implements Map<K,V> {

    /**
     * - calculate the hash of the key
     * - implement the file structure to contain both keys and values
     * -- contain a set as a separate collection of keys (or may better it's hashes?)
     * -- contain a set of Entries where each Entry is the tree of values
     * */

    private Entry[] table;

    public HashMap() {
        this.table = new Entry[16];
        // the size of table should be power of two, the reason is in calculating the hash of the bucket (key & (length - 1))
        // otherwise collection will get only two buckets which makes this structure inefficient
    }

    @Override
    public V get(Object key) {
        java.util.HashMap map = new java.util.HashMap();
        int keyHash = calculateHash((K) key);
        Entry<K,V>[] tab = table;
        int index = keyHash & (table.length - 1);
        for (Entry<K,V> entry = tab[index]; entry.next != null; entry = entry.next) {
            if (entry.key == key || (entry.key.hashCode()== keyHash && key.equals(entry.key))) {
                return entry.value;
            }
        }
        return null;
    }

    @Override
    public V put(K key, V value) {
        // doesn't cover null key case
        int keyHash = calculateHash(key);
        Entry<K,V>[] set = table;
        int index = keyHash & (set.length - 1);
        for (Entry<K,V> entry = table[index]; entry != null; entry = entry.next) {
            if (entry.key == key && entry.hash == keyHash) {
                entry.value = value;
                return value;
            }
        }

        // TODO check boundaries, double table if necessary and recalculate indexes
        // TODO add a new entry
        addNewEntry(key, value, index, keyHash);
        return null;
    }

    private void addNewEntry(K key, V value, int index, int keyHash) {
        table[index] = new Entry(key, value, keyHash, table[index]);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Collection<V> values() {
        return null;
    }

    private int calculateHash(K key) {
//        return Collections.secondaryHash(key);
        return -1;
    }

    private class Entry<K,V> {
        private K key;
        private V value;
        private int hash;
        private Entry<K,V> next;

        public Entry(K key, V value, int hash, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.hash = hash;
            this.next = next;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        @Override
        public int hashCode() {
            return (key == null ? 0 : key.hashCode())
                    ^ (value == null ? 0 : value.hashCode());
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Entry)) {
                return false;
            }
            return this.key.equals(((Entry) o).getKey())
                    && this.value.equals(((Entry) o).getValue());
        }
    }
}
