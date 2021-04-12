package me.study.ds.basic;

public class DoublyLinkedList<E> implements List<E> {
    private DLNode<E> head;
    private int size;

    @Override
    public DLNode<E> search(E item) {
        DLNode<E> p = head;
        while (p != null && !p.item.equals(item)) {
            p = (DLNode<E>) p.next;
        }
        return p;
    }

    @Override
    public void insert(E item) {
        DLNode<E> n = new DLNode<>(item);
        n.next = head;
        if (head != null) {
            head.prev = n;
        }
        head = n;
        size++;
    }

    @Override
    public void delete(E item) {
        DLNode<E> n = search(item);
        if (n != null) {
            delete(n);
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    private void delete(DLNode<E> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = (DLNode<E>) node.next;
        }
        if (node.next != null) {
            ((DLNode<E>) node.next).prev = node.prev;
        }
    }

}
