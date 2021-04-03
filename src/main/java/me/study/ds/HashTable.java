package me.study.ds;

public class HashTable<K extends Comparable<K>, V> {

    private int capacity;
    public static class Entry<K extends Comparable<K>, V> implements Comparable<Entry<K, V>> {
        private final K key;
        private V value;

        private Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        @Override
        public int compareTo(Entry<K, V> o) {
            return this.key.compareTo(o.key);
        }
    }

    BinarySearchTree<Entry<K, V>>[] table;

    @SuppressWarnings("unchecked")
    public HashTable(int capacity) {
        this.capacity = capacity;
        table = new BinarySearchTree[capacity];
    }

    public void put(K key, V value) {
        int h = hash(key);
        if (table[h] == null) {
            table[h] = new BinarySearchTree<>();
        }
        BinarySearchTree<Entry<K, V>> tree = table[h];
        Entry<K, V> e = new Entry<>(key, value);
        BTNode<Entry<K, V>> p = tree.search(e);
        if (p == null) {
            tree.insert(e);
        } else {
            p.item.value = value;
        }
    }

    public V get(K key) {
        int h = hash(key);
        if (table[h] == null) {
            return null;
        }
        BinarySearchTree<Entry<K, V>> tree = table[h];
        return tree.search(new Entry<>(key, null)).item.value;
    }

    private int hash(K key) {
        return Math.abs(key.hashCode()) % capacity;
    }

}
