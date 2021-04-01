package me.study.ds;

import java.util.Comparator;

public class Heap<T> {
    private final Object[] data;
    private final int capacity;
    private int size;
    private Comparator<T> comparator;

    public Heap(int capacity, Comparator<T> comparator) {
        this.capacity = capacity;
        this.data = new Object[this.capacity];
        this.comparator = comparator;
    }

    public Heap(int capacity) {
        this(capacity, null);
    }

    public Heap(T[] arr, Comparator<T> comparator) {
        this.comparator = comparator;
        this.capacity = arr.length;
        this.size = arr.length;
        this.data = arr.clone();
        for (int i = arr.length / 2; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    public Heap(T[] arr) {
        this(arr, null);
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
        data[size] = item;
        bubbleUp(size);
        size++;
    }

    @SuppressWarnings("unchecked")
    private void bubbleUp(int n) {
        int p = parent(n);
        while (p != -1 && compare((T) data[n], (T) data[p]) < 0) {
            swap(data, p, n);
            n = p;
            p = parent(n);
        }
    }

    private void bubbleDown(int n) {
        for (int min = getMinChild(n); n != min; n = min, min = getMinChild(n)) {
            swap(data, n, min);
        }
    }

    @SuppressWarnings("unchecked")
    public T top() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return (T) data[0];
    }

    @SuppressWarnings("unchecked")
    public T extract() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        T top = (T) data[0];
        data[0] = data[size - 1];
        bubbleDown(0);
        data[--size] = null;
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
        T min = (T) data[n];
        int minIndex = n;
        for (int i = 0; i <= 1; i++) {
            int index = 2 * n + 1 + i;
            T value = get(index);
            if (value != null && compare(value, min) < 0) {
                minIndex = index;
                min = (T) data[minIndex];
            }
        }
        return minIndex;
    }

    @SuppressWarnings("unchecked")
    private T get(int index) {
        return index >= size ? null : (T) data[index];
    }

    @SuppressWarnings("unchecked")
    private int compare(T a, T b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        return ((Comparable<T> ) a).compareTo(b);
    }
}
