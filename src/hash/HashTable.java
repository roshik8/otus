package hash;

import java.util.Arrays;
import java.util.Objects;

public class HashTable<K, V> {
    private Entry<K, V>[] buckets;
    private int threshold;
    private final float loadFactor;
    private int count;

    @SuppressWarnings("unchecked")
    public HashTable(int initialCapacity, float loadFactor) {
        this.loadFactor = loadFactor;
        buckets = (Entry<K, V>[]) new Entry[initialCapacity];
        threshold = (int) (initialCapacity * loadFactor);
    }

    public HashTable() {
        this(11, 0.75f);
    }
    public HashTable(int initialCapacity) {
        this(initialCapacity, 0.75f);
    }

    public int size() {
        return count;
    }

    public V put(K key, V value) {
        if (value == null) {
            throw new NullPointerException();
        }
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];

        while (entry != null) {
            if (entry.key.equals(key)) {
                V old = entry.value;
                entry.value = value;
                return old;
            } else {
                entry = entry.next;
            }
        }
        if (count >= threshold) {
            rehash();
            index = getIndex(key);
        }
        entry = new Entry<K, V>(key, value);
        entry.next = buckets[index];
        buckets[index] = entry;
        count++;
        return null;
    }

    @SuppressWarnings("unchecked")
    protected void rehash() {
        int oldCapacity = buckets.length;
        Entry<K, V>[] oldBuckets = buckets;
        int newCapacity = (buckets.length * 2) + 1;
        threshold = (int) (newCapacity * loadFactor);
        buckets = (Entry<K, V>[]) new Entry[newCapacity];
        for (int i = oldCapacity - 1; i >= 0; i--) {
            Entry<K, V> entry = oldBuckets[i];
            while (entry != null) {
                int index = getIndex(entry.key);
                Entry<K, V> newEntry = buckets[index];
                if (newEntry != null) {
                    Entry<K, V> next = newEntry.next;
                    while (next != null) {
                        newEntry = next;
                        next = newEntry.next;
                    }
                    newEntry.next = entry;
                } else {
                    buckets[index] = entry;
                }

                Entry<K, V> next = entry.next;
                entry.next = null;
                entry = next;
            }
        }
    }

    public V remove(Object key) {
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];
        Entry<K, V> prev = null;
        while (entry != null) {
            if (entry.key.equals(key)) {
                if (prev != null) {
                    prev.next = entry.next;
                } else {
                    buckets[index] = entry.next;
                }
                count--;
                V oldValue = entry.value;
                entry.value = null;
                return oldValue;
            }
            prev = entry;
            entry = entry.next;
        }
        return null;
    }

    public V get(Object key) {
        int index = getIndex(key);
        Entry<K, V> entry = buckets[index];
        while (entry != null) {
            if (entry.key.equals(key)) {
                return entry.value;
            } else {
                entry = entry.next;
            }
        }
        return null;
    }

    private int getIndex(Object key) {
        int hash = key.hashCode() % buckets.length;
        return hash < 0 ? -hash : hash;
    }

    private static class Entry<K, V> {
        private final K key;
        private V value;
        Entry<K, V> next;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public V setValue(V value) {
            V oldValue = this.value;
            this.value = value;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Entry<?, ?> entry = (Entry<?, ?>) o;
            return Objects.equals(key, entry.key) && Objects.equals(value, entry.value);
        }

        public int hashCode() {
            return (key == null ? 0 : key.hashCode()) ^
                    (value == null ? 0 : value.hashCode());
        }

        public String toString() {
            return key + "=" + value;
        }
    }

    @Override
    public String toString() {
        return "HashTable{" +
                "buckets=" + Arrays.toString(buckets) +
                '}';
    }
}
