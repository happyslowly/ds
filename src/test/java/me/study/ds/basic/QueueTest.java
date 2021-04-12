package me.study.ds.basic;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new ArrayQueue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        Assert.assertEquals(1, (int) queue.peek());
        Assert.assertEquals(1, (int) queue.dequeue());

        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(7);
        queue.enqueue(8);
        queue.enqueue(9);

        Assert.assertEquals(6, queue.size());
        Assert.assertEquals(4, (int) queue.peek());
    }

}