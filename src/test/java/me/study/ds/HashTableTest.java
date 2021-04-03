package me.study.ds;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashTableTest {

    @Test
    public void test() {
        HashTable<String, Integer> table = new HashTable<>(10);
        table.put("Java", 10);
        table.put("Rust", 20);
        table.put("Java", 15);

        Assert.assertEquals(15, (int) table.get("Java"));
        Assert.assertEquals(20, (int) table.get("Rust"));
        Assert.assertNull(table.get("Python"));
    }

}