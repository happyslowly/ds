package me.study.ds.basic;

public interface Stack<E> {
    boolean isEmpty();

    void push(E item);

    E pop();

    E top();

    int size();
}
