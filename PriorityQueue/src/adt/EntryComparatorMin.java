package adt;

public class EntryComparatorMin<T extends Entry<?, ?>>
        implements Comparator<T> {

    public int compare(T a, T b) {
        return (int) (a.getKey().doubleValue() - b.getKey().doubleValue());
    }

}
