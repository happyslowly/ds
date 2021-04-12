package me.study.ds.basic;

public class ArrayStack<E> implements Stack<E> {
    private static final int INITIAL_CAPACITY = 8;

    private Object[] data;
    private int capacity = INITIAL_CAPACITY;
    private int size = 0;

    public ArrayStack(int capacity) {
        this.capacity = capacity;
        this.data = new Object[capacity];
    }

    public ArrayStack() {
        this.data = new Object[capacity];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E item) {
        if (size == capacity) {
            resize(size * 2);
        }
        data[size++] = item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E pop() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        E item = (E) data[--size];
        data[size] = null;
        if (size > 0 && size == capacity / 4) {
            resize(capacity / 2);
        }
        return item;
    }

    @Override
    @SuppressWarnings("unchecked")
    public E top() {
        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty.");
        }
        return (E) data[size - 1];
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
}
