package adt;

import java.lang.reflect.Array;

public class Heap<T, C extends Comparator<Entry<Integer, T>>> {

    C comparator;
    Entry<Integer, T>[] heapArray;
    int heapSize = 0;

    public Heap(C comparator) {
        this.comparator = comparator;
        heapArray = (Entry<Integer, T>[]) Array.newInstance(Entry.class, 4);
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    private int parent(int index) {
        return (index - 1) / 2;
    }

    private void swapHeapElements(int first, int second) {
        Entry<Integer, T> temp = heapArray[first];
        heapArray[first] = heapArray[second];
        heapArray[second] = temp;
    }

    private void heapifyDown(int index) {
        int minIndex = index;
        int left = leftChild(index);
        int right = rightChild(index);

        if (left < heapSize && comparator.compare(heapArray[left], heapArray[minIndex]) < 0) {
            minIndex = left;
        }

        if (right < heapSize && comparator.compare(heapArray[right], heapArray[minIndex]) < 0) {
            minIndex = right;
        }

        if (index != minIndex) {
            swapHeapElements(index, minIndex);
            heapifyDown(minIndex);
        }
    }

    private void heapifyUp(int index) {
        while (index > 0 &&
                comparator.compare(heapArray[index], heapArray[parent(index)]) < 0) {
            swapHeapElements(index, parent(index));
            index = parent(index);
        }
    }

    private void resize() {
        Entry<Integer, T>[] newArray =
                (Entry<Integer, T>[]) Array.newInstance(Entry.class, heapArray.length * 2);
        for (int i = 0; i < heapArray.length; i++) {
            newArray[i] = heapArray[i];
        }
        heapArray = newArray;
    }

    public Entry<Integer, T> insert(int key, T value) {
        if (heapSize >= heapArray.length) {
            resize();
        }
        int index = heapSize++;
        var entry = new HeapEntry<>(key, value);
        heapArray[index] = entry;
        heapifyUp(index);
        return entry;
    }

    public void remove(Entry<Integer, T> entry) {
        for (int i = 0; i < heapSize; i++) {
            if (heapArray[i] == entry) {
                heapArray[i] = heapArray[heapSize - 1];
                heapSize--;
                heapifyDown(0);
                return;
            }
        }
    }

    public Entry<Integer, T> remove() {
        Entry<Integer, T> entry = top();
        heapArray[0] = heapArray[heapSize - 1];
        heapSize--;
        heapifyDown(0);
        return entry;
    }

    public Entry<Integer, T> top() {
        return heapArray[0];
    }

    public int replaceKey(Entry<Integer, T> entry, int newKey) {
        for (int i = 0; i < heapSize; i++) {
            if (heapArray[i] == entry) {
                heapArray[i] = new HeapEntry<>(newKey, entry.getValue());
                heapifyDown(0);
            }
        }
        return entry.getKey();
    }

    public T replaceValue(Entry<Integer, T> entry, T newValue) {
        for (int i = 0; i < heapSize; i++) {
            if (heapArray[i] == entry) {
                heapArray[i] = new HeapEntry<>(entry.getKey(), newValue);
            }
        }
        return entry.getValue();
    }

    public int size() {
        return heapSize;
    }

    public boolean isEmpty() {
        return heapSize <= 0;
    }

    public void setComparator(C comparator) {
        this.comparator = comparator;
        for (int i = (heapSize / 2) - 1; i >= 0; i--)
            heapifyDown(i);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < heapSize; i++) {
            str += "[" + heapArray[i].getKey() + "] " + heapArray[i].getValue().toString() + "\n";
        }
        return str;
    }

}
