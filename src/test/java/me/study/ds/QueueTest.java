package me.study.ds;

import org.junit.Assert;
import org.junit.Test;

public class QueueTest {

    @Test
    public void test() {
        Queue<Integer> queue = new Queue<>(3);
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        Assert.assertTrue(queue.isFull());

        Assert.assertEquals(1, (int) queue.peek());
        Assert.assertTrue(queue.isFull());

        Assert.assertEquals(1, (int) queue.dequeue());
        Assert.assertEquals(2, (int) queue.dequeue());
        Assert.assertEquals(3, (int) queue.dequeue());

        Assert.assertTrue(queue.isEmpty());
    }

}