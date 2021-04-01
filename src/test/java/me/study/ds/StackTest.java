package me.study.ds;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

    @Test
    public void test() {
        Stack<Integer> stack = new Stack<>();

        Assert.assertTrue(stack.isEmpty());

        stack.push(1);
        stack.push(2);
        stack.push(3);

        Assert.assertEquals(3, (int) stack.pop());

        Assert.assertEquals(2, stack.size());

        Assert.assertEquals(2, (int) stack.pop());
        Assert.assertEquals(1, (int) stack.pop());

        Assert.assertTrue(stack.isEmpty());
    }


}