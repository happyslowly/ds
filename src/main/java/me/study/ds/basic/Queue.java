package me.study.ds.basic;

public interface Queue<E> {
    void enqueue(E item);

    E dequeue();

    boolean isEmpty();

    E peek();

    int size();
}
