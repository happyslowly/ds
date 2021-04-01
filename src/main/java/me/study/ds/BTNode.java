package me.study.ds;

public class BTNode<T> {
    T item;
    BTNode<T> left;
    BTNode<T> right;

    public BTNode(T item) {
        this.item = item;
    }
}
