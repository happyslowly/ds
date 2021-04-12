package me.study.ds.basic;

import org.junit.Assert;
import org.junit.Test;

import static me.study.ds.TestData.smallArray;

public class PriorityQueueTest {

    @Test
    public void insert() {
        PriorityQueue<Integer> heap = new HeapPriorityQueue<>();

        for (int i : smallArray) {
            heap.offer(i);
        }

        Assert.assertEquals(1, (int) heap.poll());
        Assert.assertEquals(7, heap.size());
    }
}