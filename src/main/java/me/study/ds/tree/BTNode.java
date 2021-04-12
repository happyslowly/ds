package me.study.ds.tree;

import lombok.Data;

@Data
public class BTNode<T> {
    T item;
    BTNode<T> left;
    BTNode<T> right;
    BTNode<T> parent;

    public BTNode(T item) {
        this.item = item;
    }
}
