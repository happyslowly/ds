package me.study.ds;

public class Queue<T> {
    private final Object[] data;
    private int head;
    private int tail;

    public Queue(int capacity) {
        data = new Object[capacity + 1];
    }

    public void enqueue(T item) {
        if (isFull()) {
            throw new IllegalStateException("Queue is full");
        }
        data[tail] = item;
        tail = (tail + 1) % data.length;
    }

    @SuppressWarnings("unchecked")
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        T item = (T) data[head];
        head = (head + 1) % data.length;
        return item;
    }

    public boolean isEmpty() {
        return head == tail;
    }

    public boolean isFull() {
        return (tail + 1) % data.length == head;
    }

    @SuppressWarnings("unchecked")
    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("Queue is empty");
        }
        return (T) data[head];
    }
}
