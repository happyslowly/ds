package me.study.ds.basic;

public class ArrayQueue<E> implements Queue<E> {
    private static final int INITIAL_CAPACITY = 8;
    private Object[] data;
    private int head;
    private int tail;
    private int capacity;

    public ArrayQueue(int capacity) {
        this.capacity = capacity;
        data = new Object[capacity + 1];
    }

    public ArrayQueue() {
        this(INITIAL_CAPACITY);
    }

    @Override
    public void enqueue(E item) {
        if (isFull()) {
            resize(capacity * 2 + 1);
        }
        data[tail] = item;
        tail = (tail + 1) % data.length;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        E item = (E) data[head];
        data[head] = null;
        head = (head + 1) % data.length;
        return item;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    private boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty.");
        }
        return (E) data[head];
    }

    @Override
    public int size() {
        return tail > head ? tail - head : data.length - (head - tail);
    }

    private void resize(int max) {
        Object[] temp = new Object[max];
        int size = size();
        for (int i = 0, j = head; i < size; i++, j = (j + 1) % data.length) {
            temp[i] = data[j];
        }
        head = 0;
        tail = size;
        capacity = max - 1;
        data = temp;
    }
}
