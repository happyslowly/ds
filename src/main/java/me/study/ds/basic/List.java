package me.study.ds.basic;

public interface List<E> {
    boolean isEmpty();

    Node<E> search(E item);

    void insert(E item);

    void delete(E item);

    int size();
}
