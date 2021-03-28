package me.study.algo;

public class LinkedList<T> {

    private ListNode<T> head;
    private int size;

    public static class ListNode<T> {
        public ListNode() {
        }

        public ListNode(T item) {
            this.item = item;
        }

        T item;
        ListNode<T> next;

        @Override
        public String toString() {
            return "ListNode{" +
                    "item=" + item +
                    '}';
        }
    }

    public static <T> LinkedList<T> from(T[] arr) {
        LinkedList<T> list = new LinkedList<>();
        ListNode<T> dummy = new ListNode<>();
        ListNode<T> p = dummy;

        for (T a : arr) {
            p.next = new ListNode<T>(a);
            p = p.next;
            list.size++;
        }
        list.head = dummy.next;
        dummy.next = null;
        return list;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public ListNode<T> search(T item) {
        return search(head, item);
    }

    private ListNode<T> search(ListNode<T> h, T item) {
        if (h== null) {
            return null;
        }
        if (item.equals(h.item)) {
            return h;
        }
        return search(h.next, item);
    }

    public void push(T item) {
        ListNode<T> node = new ListNode<>(item);
        node.next = head;
        head = node;
        size++;
    }

    public void delete(T item) {
        ListNode<T> p = search(item);
        if (p != null) {
            ListNode<T> prev = predecessor(head, item);
            if (prev == null) {
                head = p.next;
            } else {
                prev.next = p.next;
                p.next = null;
            }
            size--;
        }
    }

    private ListNode<T> predecessor(ListNode<T> h, T item) {
        if (h == null || h.next == null) {
            return null;
        }
        if (h.next.item.equals(item)) {
            return h;
        }
        return predecessor(h.next, item);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (ListNode<T> p = head; p != null; p = p.next) {
            if (p != head) {
                sb.append("->");
            }
            sb.append(p);
        }
        return sb.toString();
    }

    public int getSize() {
        return size;
    }
}
