package me.study.ds.basic;

import org.junit.Assert;
import org.junit.Test;

public class LinkedListTest {

    @Test
    public void test() {
        List<String> list = SinglyLinkedList.from(new String[]{"a", "b", "c"});
        Assert.assertEquals("b", list.search("b").item);

        list.delete("b");
        Assert.assertNull(list.search("b"));
        Assert.assertEquals(2, list.size());
    }


}