package me.study.ds;

public class DoublyLinkedList<T> {
    private ListNode<T> head;

    public static class ListNode<T> {
        private T item;
        private ListNode<T> prev;
        private ListNode<T> next;

        public ListNode(T item) {
            this.item = item;
        }
    }

    public ListNode<T> search(T item) {
        ListNode<T> p = head;
        while (p != null && !p.item.equals(item)) {
            p = p.next;
        }
        return p;
    }

    public void insert(T item) {
        ListNode<T> n = new ListNode<>(item);
        n.next = head;
        if (head != null) {
            head.prev = n;
        }
        head = n;
    }

    public void delete(ListNode<T> node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
    }

    public boolean isEmpty() {
        return head == null;
    }

}
