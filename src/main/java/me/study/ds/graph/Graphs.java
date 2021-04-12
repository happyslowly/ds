package me.study.ds.graph;

import java.util.*;

public class Graphs {

    private enum Color {
        BLACK, WHITE;
    }

    public static <V, E> boolean twoColors(Graph<V, E> g) {
        Map<V, Color> colors = new HashMap<>();
        Set<V> discovered = new HashSet<>();
        final boolean[] canTwoColors = {true};

        GraphTraversal<V, E> bfs = new AbstractBfsTraversal<V, E>(g) {
            @Override
            void preProcessVertex(V v) {
                discovered.add(v);
            }

            @Override
            void postProcessVertex(V v) {

            }

            @Override
            void processEdge(V u, V v) {
                if (colors.get(u) == colors.get(v)) {
                    canTwoColors[0] = false;
                    return;
                }
                if (colors.get(u) == Color.BLACK) {
                    colors.put(v, Color.WHITE);
                } else {
                    colors.put(v, Color.BLACK);
                }
            }
        };

        for (V u : g.getVertices()) {
            if (!discovered.contains(u)) {
                colors.put(u, Color.WHITE);
                bfs.traverse(u);
            }
        }
        return canTwoColors[0];
    }

    public static <V, E> int connectedComponents(Graph<V, E> g) {
        Set<V> discovered = new HashSet<>();
        GraphTraversal<V, E> bfs = new AbstractBfsTraversal<V, E>(g) {
            @Override
            void preProcessVertex(V v) {
                discovered.add(v);
            }

            @Override
            void postProcessVertex(V v) {

            }

            @Override
            void processEdge(V u, V v) {

            }
        };

        int c = 0;
        for (V u : g.getVertices()) {
            if (!discovered.contains(u)) {
                c++;
                bfs.traverse(u);
            }
        }
        return c;
    }

    public static <V, E> List<V> findPath(Graph<V, E> g, V start, V end) {
        PathFinder<V, E> finder = new PathFinder<>(g);
        finder.traverse(start);
        if (!finder.vertices.contains(end)) {
            return Collections.emptyList();
        }
        V p = end;
        Deque<V> stack = new ArrayDeque<>();
        stack.push(p);
        while ((p = finder.parents.get(p)) != null) {
            stack.push(p);
        }
        return new ArrayList<>(stack);
    }

    private static class PathFinder<V, E> extends AbstractBfsTraversal<V, E> {
        private final Map<V, V> parents;
        private final Set<V> vertices;

        public PathFinder(Graph<V, E> g) {
            super(g);
            parents = new HashMap<>();
            vertices = new HashSet<>();
        }

        @Override
        void preProcessVertex(V v) {
            vertices.add(v);
        }

        @Override
        void postProcessVertex(V v) {

        }

        @Override
        void processEdge(V u, V v) {
            parents.put(v, u);
        }
    }

}
