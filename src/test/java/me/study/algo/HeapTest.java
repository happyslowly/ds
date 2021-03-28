package me.study.algo;

import org.junit.Assert;
import org.junit.Test;

public class HeapTest {

    @Test
    public void insert() {
        Heap<Integer> heap = new Heap<>(10);
        heap.insert(3);
        heap.insert(1);
        heap.insert(4);
        heap.insert(5);
        heap.insert(2);

        Assert.assertEquals(1, (int) heap.extract());
        Assert.assertEquals(4, heap.size());
    }
}