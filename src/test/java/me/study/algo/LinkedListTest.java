package me.study.algo;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void test() {
        LinkedList<String> list = LinkedList.from(new String[]{"a", "b", "c"});
        LinkedList.ListNode<String> n = list.search("b");

        Assert.assertEquals("b", list.search("b").item);
        list.delete("b");
        Assert.assertNull(list.search("b"));
    }


}