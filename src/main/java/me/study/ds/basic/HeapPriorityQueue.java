package me.study.ds.basic;

import java.util.Comparator;

public class HeapPriorityQueue<E> implements PriorityQueue<E> {
    private static final int INITIAL_CAPACITY = 8;
    private Object[] data;
    private int capacity;
    private int size;
    private final Comparator<E> comparator;

    public HeapPriorityQueue(int capacity, Comparator<E> comparator) {
        this.capacity = capacity;
        this.data = new Object[this.capacity];
        this.comparator = comparator;
    }

    public HeapPriorityQueue(int capacity) {
        this(capacity, null);
    }

    public HeapPriorityQueue(E[] arr, Comparator<E> comparator) {
        this.comparator = comparator;
        this.capacity = arr.length;
        this.size = arr.length;
        this.data = arr.clone();
        for (int i = arr.length / 2; i >= 0; i--) {
            bubbleDown(i);
        }
    }

    public HeapPriorityQueue(E[] arr) {
        this(arr, null);
    }

    public HeapPriorityQueue() {
        this(INITIAL_CAPACITY);
    }

    private int parent(int n) {
        if (n == 0) {
            return -1;
        }
        return (n - 1) / 2;
    }

    @Override
    public void offer(E item) {
        if (isFull()) {
            resize(capacity * 2);
        }
        data[size] = item;
        bubbleUp(size);
        size++;
    }

    @SuppressWarnings("unchecked")
    private void bubbleUp(int n) {
        int p = parent(n);
        while (p != -1 && compare((E) data[n], (E) data[p]) < 0) {
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

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return (E) data[0];
    }

    @Override
    @SuppressWarnings("unchecked")
    public E poll() {
        if (isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        E top = (E) data[0];
        data[0] = data[--size];
        data[size] = null;
        bubbleDown(0);
        return top;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private boolean isFull() {
        return size == capacity;
    }

    @Override
    public int size() {
        return size;
    }

    private void resize(int max) {
        Object[] temp = new Object[max];
        if (size >= 0) System.arraycopy(data, 0, temp, 0, size);
        capacity = max;
        data = temp;
    }

    private void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    @SuppressWarnings("unchecked")
    private int getMinChild(int n) {
        E min = (E) data[n];
        int minIndex = n;
        for (int i = 0; i <= 1; i++) {
            int index = 2 * n + 1 + i;
            E value = get(index);
            if (value != null && compare(value, min) < 0) {
                minIndex = index;
                min = (E) data[minIndex];
            }
        }
        return minIndex;
    }

    @SuppressWarnings("unchecked")
    private E get(int index) {
        return index >= size ? null : (E) data[index];
    }

    @SuppressWarnings("unchecked")
    private int compare(E a, E b) {
        if (comparator != null) {
            return comparator.compare(a, b);
        }
        return ((Comparable<E> ) a).compareTo(b);
    }
}
