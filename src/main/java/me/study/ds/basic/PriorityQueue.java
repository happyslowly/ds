package me.study.ds.basic;

public interface PriorityQueue<E> {
    void offer(E item);

    E peek();

    E poll();

    boolean isEmpty();

    int size();
}
