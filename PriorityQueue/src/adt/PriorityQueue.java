package adt;

public class PriorityQueue<T> {

    boolean isMinHeap = true;
    Comparator<Entry<Integer, T>> comparator;
    Heap<T, Comparator<Entry<Integer, T>>> heap;

    public PriorityQueue() {
        comparator = new EntryComparatorMin<>();
        heap = new Heap<>(comparator);
    }

    public Entry<Integer, T> removeTop() {
        return heap.remove();
    }

    public Entry<Integer, T> top() {
        return heap.top();
    }

    public Entry<Integer, T> insert(int key, T value) {
        return heap.insert(key, value);
    }

    public void remove(Entry<Integer, T> entry) {
        heap.remove(entry);
    }

    public int replaceKey(Entry<Integer, T> entry, int newKey) {
        return heap.replaceKey(entry, newKey);
    }

    public T replaceValue(Entry<Integer, T> entry, T newValue) {
        return heap.replaceValue(entry, newValue);
    }

    public void toggle() {
        heap.setComparator(
                isMinHeap ?
                        new EntryComparatorMax<>() :
                        new EntryComparatorMin<>());
        isMinHeap = !isMinHeap;
    }

    public boolean state() {
        return isMinHeap;
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public int size() {
        return heap.size();
    }

    public String toString() {
        return heap.toString();
    }

}
