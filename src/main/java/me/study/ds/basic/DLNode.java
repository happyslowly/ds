package me.study.ds.basic;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class DLNode<E> extends Node<E> {
    protected Node<E> prev;

    public DLNode(E item) {
        super(item);
    }
}
