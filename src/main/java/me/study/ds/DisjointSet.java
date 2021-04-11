package me.study.ds;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DisjointSet<E> {
    private final Map<E, Node<E>> nodes = new HashMap<>();
    private final Set<Node<E>> roots = new HashSet<>();

    private static class Node<E> {
        private final E item;
        private Node<E> parent;
        private Node<E> next;
        private int rank;

        private Node(E item) {
            this.item = item;
            this.parent = this;
            this.next = this;
        }
    }

    protected Node<E> makeSet(E item) {
        if (!nodes.containsKey(item)) {
            nodes.put(item, new Node<>(item));
        }
        return nodes.get(item);
    }

    public void union(E x, E y) {
        Node<E> nx = makeSet(x);
        Node<E> ny = makeSet(y);
        link(findSet(nx), findSet(ny));
    }

    private void link(Node<E> nx, Node<E> ny) {
        if (nx == ny) {
            return;
        }

        if (nx.rank < ny.rank) {
            nx.parent = ny;
            roots.add(ny);
            roots.remove(nx);
        } else {
            ny.parent = nx;
            roots.add(nx);
            roots.remove(ny);
            if (nx.rank == ny.rank) {
                nx.rank += 1;
            }
        }
        Node<E> t = nx.next;
        nx.next = ny.next;
        ny.next = t;
    }

    protected Node<E> findSet(Node<E> node) {
        if (node == null) {
            return null;
        }
        // path compression
        if (node != node.parent) {
            node.parent = findSet(node.parent);
        }
        return node.parent;
    }

    protected Node<E> findSet(E item) {
        return findSet(nodes.get(item));
    }

    public boolean sameSet(E x, E y) {
        return findSet(x) == findSet(y);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Node<E> root : roots) {
            sb.append(setToString(root)).append('\n');
        }
        return sb.toString();
    }

    private String setToString(Node<E> root) {
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        Node<E> p = root;
        if (p != null) {
            do {
                sb.append(p.item).append(',');
                p = p.next;
            } while (p != root);
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append('}');
        return sb.toString();
    }
}
