package me.study.ds.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public abstract class AbstractGraphTraversal<V, E> implements GraphTraversal<V, E> {
    protected final Graph<V, E> g;
    protected final Map<V, V> parents = new HashMap<>();
    protected final Set<V> marked = new HashSet<>();
    protected final Set<V> processed = new HashSet<>();

    public AbstractGraphTraversal(Graph<V, E> g) {
        this.g = g;
    }

    abstract void preProcessVertex(V v);

    abstract void postProcessVertex(V v);

    abstract void processEdge(V u, V v);

}
