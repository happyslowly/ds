package me.study.ds.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.stream.Collectors;

public class AdjacencyMapGraphTest {

    @Test
    public void test() {
        Graph<Integer, Integer> g = new AdjacencyMapGraph<>(false);
        g.insert(0, 1);
        g.insert(0, 2);
        g.insert(0, 6);
        g.insert(0, 5);
        g.insert(6, 4);
        g.insert(4, 3);
        g.insert(4, 5);
        g.insert(3, 5);
        g.insert(7, 8);
        g.insert(9, 10);
        g.insert(9, 11);
        g.insert(9, 12);
        g.insert(11, 12);

//        Assert.assertEquals(13, g.getNumVertices());
//        Assert.assertEquals(13, g.getNumEdges());
//
//        Assert.assertEquals(Collections.emptyList(), Graphs.findShortestPath(g, 1, 8));
//        Assert.assertEquals(Arrays.asList(1, 0, 5, 3), Graphs.findShortestPath(g, 1, 3));
//
//        Assert.assertEquals(3,
//                new HashSet<>(Graphs.connectedComponents(g).values()).size());
        Assert.assertTrue(Graphs.hasCycle(g));
    }

    @Test
    public void test2() {
        Graph<String, String> g = new AdjacencyMapGraph<>(false);
        g.insert("a", "b");
        g.insert("b", "c");
        g.insert("c", "a");

        System.out.println(Graphs.hasCycle(g));
    }

}