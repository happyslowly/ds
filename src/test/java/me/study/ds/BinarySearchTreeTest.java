package me.study.ds;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeTest {

    @Test
    public void test() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(1);
        bst.insert(7);
        bst.insert(3);
        bst.insert(4);
        bst.insert(10);
        bst.insert(9);
        bst.delete(7);

        List<Integer> list = new ArrayList<>();
        bst.traverse(list::add);

        Assert.assertTrue(TestHelper.isSorted(list.toArray(new Integer[0])));
    }

    @Test
    public void testUnbalanced() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(3);
        bst.insert(1);
        bst.insert(2);

        Assert.assertFalse(bst.isBalanced());
    }

    @Test
    public void testAvlBalanced() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);

        Assert.assertTrue(avl.isBalanced());
        Assert.assertEquals(2, avl.getHeight());
    }

    @Test
    public void testAvlBalancedDeletion() {
        AvlTree<Integer> avl = new AvlTree<>();
        avl.insert(1);
        avl.insert(2);
        avl.insert(3);
        avl.insert(4);
        avl.insert(5);

        Assert.assertTrue(avl.isBalanced());
        avl.delete(1);
        Assert.assertTrue(avl.isBalanced());
    }

}