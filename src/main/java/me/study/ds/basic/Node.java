package me.study.ds.basic;

import lombok.Data;

@Data
public class Node<E> {
    public Node() {
    }

    public Node(E item) {
        this.item = item;
    }

    protected E item;
    protected Node<E> next;

    @Override
    public String toString() {
        return "ListNode{" +
                "item=" + item +
                '}';
    }
}
