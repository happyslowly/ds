package me.study.algo;

public class Heap<T extends Comparable<T>> {
    private final Object[] arr;
    private final int capacity;
    private int size;

    public Heap(int capacity) {
        this.capacity = capacity;
        this.arr = new Object[this.capacity];
    }

    private int parent(int n) {
        if (n == 0) {
            return -1;
        }
        return (n - 1) / 2;
    }

    public void insert(T item) {
        if (isFull()) {
            throw new IllegalStateException("Heap is full");
        }
        arr[size] = item;
        bubbleUp(size);
        size++;
    }

    @SuppressWarnings("unchecked")
    private void bubbleUp(int n) {
        int p = parent(n);
        while (p != -1 && ((T) arr[n]).compareTo((T) arr[p]) < 0) {
            swap(arr, p, n);
            n = p;
            p = parent(n);
        }
    }

    private void bubbleDown(int n) {
        for (int min = getMinChild(n); n != min; n = min, min = getMinChild(n)) {
            swap(arr, n, min);
        }
    }

    @SuppressWarnings("unchecked")
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return (T) arr[0];
    }

    @SuppressWarnings("unchecked")
    public T extract() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T top = (T) arr[0];
        arr[0] = arr[size - 1];
        bubbleDown(0);
        arr[--size] = null;
        return top;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public int size() {
        return size;
    }

    private void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @SuppressWarnings("unchecked")
    private int getMinChild(int n) {
        T min = (T) arr[n];
        int minIndex = n;
        for (int i = 0; i <= 1; i++) {
            int index = 2 * n + 1 + i;
            T value = get(index);
            if (value != null && value.compareTo(min) < 0) {
                minIndex = index;
                min = (T) arr[minIndex];
            }
        }
        return minIndex;
    }

    @SuppressWarnings("unchecked")
    private T get(int index) {
        return index >= size ? null : (T) arr[index];
    }

}
