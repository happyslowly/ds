package me.study.algo;

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

}