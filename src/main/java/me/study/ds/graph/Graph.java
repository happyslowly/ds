package me.study.ds.graph;

public interface Graph<V, E> {
    void insert(V v1, V v2);

    int getNumEdges();

    int getNumVertices();

    int degree(V v);

    boolean isDirected();

    Iterable<V> getVertices();

    Iterable<V> getEdges(V v);

}
