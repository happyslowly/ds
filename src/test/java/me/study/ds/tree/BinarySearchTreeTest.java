package me.study.ds.tree;

import me.study.ds.tree.AvlTree;
import me.study.ds.TestHelper;
import me.study.ds.tree.BinarySearchTree;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeTest {

    @Test
    public void testBasic() {
        BinarySearchTree<Integer> bst = new BinarySearchTree<>();
        bst.insert(15);
        bst.insert(6);
        bst.insert(3);
        bst.insert(2);
        bst.insert(4);
        bst.insert(7);
        bst.insert(13);
        bst.insert(9);
        bst.insert(18);
        bst.insert(17);
        bst.insert(20);

        List<Integer> list = new ArrayList<>();
        bst.traverse(list::add);

        Assert.assertTrue(TestHelper.isSorted(list.toArray(new Integer[0])));

        Assert.assertEquals(15, (int) bst.successor(13).item);
        Assert.assertEquals(17, (int) bst.successor(15).item);

        Assert.assertEquals(4, (int) bst.predecessor(6).item);
        Assert.assertEquals(15, (int) bst.predecessor(17).item);

        bst.delete(15);
        Assert.assertEquals(17, (int) bst.successor(13).item);
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