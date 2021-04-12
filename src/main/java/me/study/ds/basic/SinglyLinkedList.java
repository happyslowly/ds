package me.study.ds.basic;

public class SinglyLinkedList<E> implements List<E> {

    private Node<E> head;
    private int size;

    public static <T> List<T> from(T[] arr) {
        SinglyLinkedList<T> list = new SinglyLinkedList<>();
        Node<T> dummy = new Node<>();
        Node<T> p = dummy;

        for (T a : arr) {
            p.next = new Node<T>(a);
            p = p.next;
            list.size++;
        }
        list.head = dummy.next;
        dummy.next = null;
        return list;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Node<E> search(E item) {
        Node<E> p = head;
        while (p != null && !p.item.equals(item)) {
            p = p.next;
        }
        return p;
    }

    @Override
    public void insert(E item) {
        Node<E> node = new Node<>(item);
        node.next = head;
        head = node;
        size++;
    }

    @Override
    public void delete(E item) {
        Node<E> p = search(item);
        if (p != null) {
            Node<E> prev = predecessor(item);
            if (prev == null) {
                head = p.next;
            } else {
                prev.next = p.next;
                p.next = null;
            }
            size--;
        }
    }

    private Node<E> predecessor(E item) {
        Node<E> p = head;

        while (p != null && p.next != null) {
            if (p.next.item.equals(item)) {
                return p;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<E> p = head; p != null; p = p.next) {
            if (p != head) {
                sb.append("->");
            }
            sb.append(p);
        }
        return sb.toString();
    }

    @Override
    public int size() {
        return size;
    }
}
