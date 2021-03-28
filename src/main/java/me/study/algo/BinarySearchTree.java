package me.study.algo;

import java.util.function.Consumer;

public class BinarySearchTree<T extends Comparable<T>> {
    private TreeNode<T> root;
    private int size;

    public static class TreeNode<T> {
        T item;
        TreeNode<T> left;
        TreeNode<T> right;
        TreeNode<T> parent;

        public TreeNode(T item) {
            this.item = item;
        }
    }

    public TreeNode<T> search(T item) {
        return search(root, item);
    }

    private TreeNode<T> search(TreeNode<T> r, T item) {
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

    public TreeNode<T> min() {
        return min(root);
    }

    private TreeNode<T> min(TreeNode<T> r) {
        if (r == null) {
            return null;
        }
        TreeNode<T> min = r;
        while (min.left != null) {
            min = min.left;
        }
        return min;
    }

    public TreeNode<T> max() {
        return max(root);
    }

    public TreeNode<T> max(TreeNode<T> r) {
        if (r == null) {
            return null;
        }
        TreeNode<T> max = r;
        while (max.right != null) {
            max = max.right;
        }
        return max;
    }

    public void traverse(Consumer<T> func) {
        traverse(root, func);
    }

    private void traverse(TreeNode<T> r, Consumer<T> func) {
        if (r == null) {
            return;
        }
        // inorder
        traverse(r.left, func);
        func.accept(r.item);
        traverse(r.right, func);
    }

    public void insert(T item) {
        root = insert(root, item, null);
    }

    private TreeNode<T> insert(TreeNode<T> r, T item, TreeNode<T> parent) {
        if (r == null) {
            TreeNode<T> node = new TreeNode<>(item);
            node.parent = parent;
            return node;
        }
        if (item.compareTo(r.item) < 0) {
            r.left = insert(r.left, item, r);
        } else {
            r.right = insert(r.right, item, r);
        }
        return r;
    }

    public void delete(T item) {
        root = delete(root, item);
    }

    private TreeNode<T> delete(TreeNode<T> r, T item) {
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
            TreeNode<T> p = min(r.right);
            r.right = delete(r.right, p.item);
            r.item = p.item;
            return r;
        }

        if (item.compareTo(r.item) < 0) {
            r.left = delete(r.left, item);
        } else {
            r.right = delete(r.right, item);
        }
        return r;
    }


    public boolean isEmpty() {
        return size == 0;
    }
}
