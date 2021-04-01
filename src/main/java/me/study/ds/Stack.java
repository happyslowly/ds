package me.study.ds;

public class Stack<T> {
    private Object[] data;
    private int capacity = 1;
    private int size;

    public Stack(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    public Stack() {
        this.data = new Object[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T item) {
        if (size == capacity) {
            resize(size * 2);
        }
        data[size++] = item;
    }

    @SuppressWarnings("unchecked")
    public T pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }
        T item = (T) data[--size];
        data[size] = null;
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
        return item;
    }

    public int size() {
        return size;
    }

    private void resize(int max) {
        Object[] temp = new Object[max];
        if (size >= 0) System.arraycopy(data, 0, temp, 0, size);
        capacity = max;
        data = temp;
    }
}
