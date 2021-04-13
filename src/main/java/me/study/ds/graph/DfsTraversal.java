package me.study.ds.graph;

public class DfsTraversal<V, E> extends AbstractGraphTraversal<V, E> {
    public DfsTraversal(Graph<V, E> g) {
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
        dfs(vertex);
    }

    private void dfs(V u) {
        preProcessVertex(u);
        marked.add(u);
        for (V v : g.getEdges(u)) {
            if (!marked.contains(v)) {
                parents.put(v, u);
                processEdge(u, v);
                dfs(v);
            } else if (!processed.contains(v) && !parents.get(u).equals(v)) {
                processEdge(u, v);
            }
            postProcessVertex(u);
        }
        processed.add(u);
    }
}
