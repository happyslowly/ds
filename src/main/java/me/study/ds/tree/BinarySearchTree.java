package me.study.ds.tree;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    protected BTNode<T> root;

    public BTNode<T> search(T item) {
        return search(root, item);
    }

    private BTNode<T> search(BTNode<T> r, T item) {
        if (r == null) {
            return null;
        }

        if (item.compareTo(r.item) == 0) {
            return r;
        }

        if (item.compareTo(r.item) < 0) {
            return search(r.left, item);
        }
        return search(r.right, item);
    }

    public BTNode<T> min() {
        return min(root);
    }

    protected BTNode<T> min(BTNode<T> r) {
        if (r == null) {
            return null;
        }
        BTNode<T> min = r;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    public BTNode<T> max() {
        return max(root);
    }

    protected BTNode<T> max(BTNode<T> r) {
        if (r == null) {
            return null;
        }
        BTNode<T> max = r;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    public BTNode<T> successor(T item) {
        return successor(search(item));
    }

    public BTNode<T> successor(BTNode<T> n) {
        if (n == null) {
            return null;
        }
        if (n.right != null) {
            return min(n.right);
        }
        BTNode<T> p = n.parent;
        while (p != null && p.right == n) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    public BTNode<T> predecessor(T item) {
        return predecessor(search(item));
    }

    public BTNode<T> predecessor(BTNode<T> n) {
        if (n == null) {
            return null;
        }
        if (n.left != null) {
            return max(n.left);
        }
        BTNode<T> p = n.parent;
        while (p != null && p.left == n) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    public void traverse(Consumer<T> func) {
        traverse(root, func);
    }

    private void traverse(BTNode<T> r, Consumer<T> func) {
        if (r == null) {
            return;
        }
        // inorder
        traverse(r.left, func);
        func.accept(r.item);
        traverse(r.right, func);
    }

    public void insert(T item) {
        root = insert(root, item);
    }

    protected BTNode<T> insert(BTNode<T> r, T item) {
        if (r == null) {
            return new BTNode<>(item);
        }
        BTNode<T> n;
        if (item.compareTo(r.item) < 0) {
            n = insert(r.left, item);
            r.left = n;
        } else {
            n = insert(r.right, item);
            r.right = n;
        }
        n.parent = r;
        return r;
    }

    public void delete(T item) {
        root = delete(root, item);
        root.parent = null;
    }

    protected BTNode<T> delete(BTNode<T> r, T item) {
        if (r == null) {
            return null;
        }

        if (item.compareTo(r.item) == 0) {
            if (r.left == null && r.right == null) {
                return null;
            }
            if (r.left == null) {
                return r.right;
            }
            if (r.right == null) {
                return r.left;
            }
            BTNode<T> p = min(r.right);
            r.right = delete(r.right, p.item);
            r.item = p.item;
            return r;
        }

        BTNode<T> n;
        if (item.compareTo(r.item) < 0) {
            n = delete(r.left, item);
            r.left = n;
        } else {
            n = delete(r.right, item);
            r.right = n;
        }
        if (n != null) {
            n.parent = r;
        }
        return r;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean isBalanced() {
        return isBalanced(root).balanced;
    }

    private static class Info {
        private final int height;
        private final boolean balanced;

        private Info(int height, boolean balanced) {
            this.height = height;
            this.balanced = balanced;
        }
    }

    private Info isBalanced(BTNode<T> root) {
        if (root == null) {
            return new Info(-1, true);
        }

        Info li = isBalanced(root.left);
        if (!li.balanced) {
            return new Info(-1, false);
        }

        Info ri = isBalanced(root.right);
        if (!ri.balanced) {
            return new Info(-1, false);
        }

        return new Info(Math.max(li.height, ri.height) + 1,
                Math.abs(li.height - ri.height) < 2);
    }
}
