package me.study.ds.graph;

import lombok.Data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Data
public class AdjacencyMapGraph<V, E> implements Graph<V, E> {

    private boolean directed;
    private final Map<V, Set<V>> edges;
    private int numEdges;
    private int numVertices;

    public AdjacencyMapGraph() {
        this.edges = new HashMap<>();
    }

    public AdjacencyMapGraph(boolean directed) {
        this();
        this.directed = directed;
    }

    @Override
    public void insert(V u, V v) {
        if (!directed) {
            insertEdge(u, v);
            insertEdge(v, u);
        } else {
            insertEdge(u, v);
        }
        numEdges++;
    }

    private void insertEdge(V u, V v) {
        if (!edges.containsKey(u)) {
            edges.put(u, new HashSet<>());
        }
        edges.get(u).add(v);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("V: ").append(numVertices);
        sb.append(", E: ").append(numEdges).append("\n");
        for (V v : edges.keySet()) {
            sb.append(v).append(": ").append(edges.get(v)).append("\n");
        }
        return sb.toString();
    }

    @Override
    public int getNumEdges() {
        return numEdges;
    }

    @Override
    public int getNumVertices() {
        return edges.size();
    }

    @Override
    public int degree(V v) {
        return edges.get(v) == null ? 0 : edges.get(v).size();
    }

    @Override
    public Iterable<V> getVertices() {
        return edges.keySet();
    }

    @Override
    public Iterable<V> getEdges(V v) {
        return edges.get(v);
    }
}
