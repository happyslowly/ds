package me.study.ds.graph;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class AdjacencyMapGraphTest {

    @Test
    public void test() {
        Graph<Integer, Integer> g = new AdjacencyMapGraph<>(false);
        g.insert(1, 2);
        g.insert(1, 5);
        g.insert(2, 5);
        g.insert(2, 4);
        g.insert(5, 4);
        g.insert(2, 3);
        g.insert(3, 4);

        Assert.assertEquals(5, g.getNumVertices());
        Assert.assertEquals(7, g.getNumEdges());

        Assert.assertEquals(Collections.emptyList(), Graphs.findPath(g, 1, 8));
        Assert.assertEquals(Arrays.asList(1, 2, 3), Graphs.findPath(g, 1, 3));

        Assert.assertEquals(1, Graphs.connectedComponents(g));
        Assert.assertFalse(Graphs.twoColors(g));
    }

}