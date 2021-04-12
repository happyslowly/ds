package me.study.ds.graph;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

abstract class AbstractBfsTraversal<V, E> extends AbstractGraphTraversal<V, E> {

    public AbstractBfsTraversal(Graph<V, E> g) {
        super(g);
    }

    @Override
    public void traverse(V vertex) {
        Queue<V> queue = new ArrayDeque<>();
        if (vertex != null) {
            queue.offer(vertex);
        }
        Set<V> visited = new HashSet<>();
        Set<V> processed = new HashSet<>();
        visited.add(vertex);
        while (!queue.isEmpty()) {
            V u = queue.poll();
            processed.add(u);
            preProcessVertex(u);
            for (V v : g.getEdges(u)) {
                if (!processed.contains(v)) {
                    processEdge(u, v);
                }
                if (!visited.contains(v)) {
                    visited.add(v);
                    queue.offer(v);
                }
            }
            postProcessVertex(u);
        }
    }

}
