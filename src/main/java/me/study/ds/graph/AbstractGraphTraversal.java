package me.study.ds.graph;

public abstract class AbstractGraphTraversal<V, E> implements GraphTraversal<V, E> {
    protected final Graph<V, E> g;

    public AbstractGraphTraversal(Graph<V, E> g) {
        this.g = g;
    }

    abstract void preProcessVertex(V v);

    abstract void postProcessVertex(V v);

    abstract void processEdge(V u, V v);

}
