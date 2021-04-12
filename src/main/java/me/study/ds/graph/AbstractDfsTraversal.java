package me.study.ds.graph;

import java.util.HashSet;
import java.util.Set;

public class AbstractDfsTraversal<V, E> extends AbstractGraphTraversal<V, E> {
    public AbstractDfsTraversal(Graph<V, E> g) {
        super(g);
    }

    @Override
    public void traverse(V vertex) {
        dfs(vertex, new HashSet<>(), new HashSet<>());
    }

    private void dfs(V u, Set<V> visited, Set<V> processed) {
        preProcessVertex(u);
        visited.add(u);
        for (V v : g.getEdges(u)) {
            if (!visited.contains(v)) {
                processEdge(u, v);
                dfs(v, visited, processed);
            } else if (!processed.contains(v) || g.isDirected()) {
                processEdge(u, v);
            }
            postProcessVertex(u);
            processed.add(u);
        }
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
}
