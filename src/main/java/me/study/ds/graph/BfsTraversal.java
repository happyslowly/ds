package me.study.ds.graph;

import java.util.ArrayDeque;
import java.util.Queue;

class BfsTraversal<V, E> extends AbstractGraphTraversal<V, E> {

    public BfsTraversal(Graph<V, E> g) {
        super(g);
    }

    @Override
    void preProcessVertex(V v) {

    }

    @Override
    void postProcessVertex(V v) {

    }

    @Override
    void processEdge(V u, V v) {

    }

    @Override
    public void traverse(V vertex) {
        Queue<V> queue = new ArrayDeque<>();
        if (vertex != null) {
            queue.offer(vertex);
        }
        marked.add(vertex);
        while (!queue.isEmpty()) {
            V u = queue.poll();
            preProcessVertex(u);
            for (V v : g.getEdges(u)) {
                if (!processed.contains(v) || g.isDirected()) {
                    processEdge(u, v);
                }
                if (!marked.contains(v)) {
                    marked.add(v);
                    parents.put(v, u);
                    queue.offer(v);
                }
            }
            postProcessVertex(u);
            processed.add(u);
        }
    }

}
