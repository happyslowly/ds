package me.study.ds;

import org.junit.Assert;
import org.junit.Test;

public class DisjointSetTest {

    @Test
    public void test() {
        DisjointSet<Character> set = new DisjointSet<>();
        set.union('b', 'd');
        set.union('e', 'g');
        set.union('a', 'c');
        set.union('h', 'i');
        set.union('a', 'b');
        set.union('e', 'f');
        set.union('b', 'c');

        Assert.assertTrue(set.sameSet('a', 'd'));

        System.out.println(set);
    }

}