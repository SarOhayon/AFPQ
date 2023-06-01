package adt;

public interface Entry<K extends Number, V> {
    K getKey();
    V getValue();
}
