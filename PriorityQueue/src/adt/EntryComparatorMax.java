package adt;

public class EntryComparatorMax<T extends Entry<?, ?>>
        implements Comparator<T> {

    public int compare(T a, T b) {
        return (int) (b.getKey().doubleValue() - a.getKey().doubleValue());
    }

}
