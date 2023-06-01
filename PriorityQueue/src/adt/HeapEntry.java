package adt;

public class HeapEntry<K extends Number, V> implements Entry<K, V> {

    private final K key;
    private final V value;

    HeapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return this.key;
    }

    public V getValue() {
        return this.value;
    }

}
