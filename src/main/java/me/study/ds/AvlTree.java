package me.study.ds;

public class AvlTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    public static class AvlNode<T> extends BTNode<T> {
        int height;

        public AvlNode(T item) {
            super(item);
        }
    }

    @Override
    protected BTNode<T> insert(BTNode<T> r, T item) {
        if (r == null) {
            return new AvlNode<>(item);
        }
        if (item.compareTo(r.item) < 0) {
            r.left = insert(r.left, item);
        } else {
            r.right = insert(r.right, item);
        }
        return rebalance(r);
    }

    @Override
    protected BTNode<T> delete(BTNode<T> r, T item) {
        if (r == null) {
            return null;
        }

        if (item.compareTo(r.item) == 0) {
            if (r.left == null && r.right == null) {
                return null;
            }
            if (r.left == null) {
                r = r.right;
            } else if (r.right == null) {
                r = r.left;
            } else {
                BTNode<T> p = min(r.right);
                r.right = delete(r.right, p.item);
                r.item = p.item;
            }
        }

        if (item.compareTo(r.item) < 0) {
            r.left = delete(r.left, item);
        } else {
            r.right = delete(r.right, item);
        }

        return rebalance(r);
    }

    private void updateHeight(BTNode<T> node) {
        ((AvlNode<T>) node).height = Math.max(height(node.left), height(node.right)) + 1;
    }

    private int height(BTNode<T> node) {
        return node == null ? -1 : ((AvlNode<T>) node).height;
    }

    private int getBalance(BTNode<T> node) {
        return height(node.left) - height(node.right);
    }

    private BTNode<T> rotateRight(BTNode<T> node) {
        if (node == null) {
            return null;
        }

        BTNode<T> p = node.left;
        node.left = p.right;
        p.right = node;
        updateHeight(node);
        updateHeight(p);
        return p;
    }

    private BTNode<T> rotateLeft(BTNode<T> node) {
        if (node == null) {
            return null;
        }

        BTNode<T> p = node.right;
        node.right = p.left;
        p.left = node;
        updateHeight(node);
        updateHeight(p);
        return p;
    }

    private BTNode<T> rebalance(BTNode<T> node) {
        updateHeight(node);
        int balance = getBalance(node);
        if (balance > 1) {
            if (height(node.left.left) < height(node.left.right)) {
                node.left = rotateLeft(node.left);
            }
            node = rotateRight(node);
        } else if (balance < -1) {
            if (height(node.right.right) < height(node.right.left)) {
                node.right = rotateRight(node.right);
            }
            node = rotateLeft(node);
        }
        return node;
    }

    protected int getHeight() {
        return ((AvlNode<T>) root).height;
    }
}
