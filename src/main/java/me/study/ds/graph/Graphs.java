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

        GraphTraversal<V, E> bfs = new BfsTraversal<V, E>(g) {
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

    public static <V, E> Map<V, Integer> connectedComponents(Graph<V, E> g) {
        ComponentsFinder<V, E> componentsFinder = new ComponentsFinder<>(g, 0);
        for (V v : g.getVertices()) {
            if (!componentsFinder.components.containsKey(v)) {
                componentsFinder.count++;
                componentsFinder.traverse(v);
            }
        }
        return componentsFinder.components;
    }

    public static <V, E> List<V> findShortestPath(Graph<V, E> g, V start, V end) {
        BfsTraversal<V, E> bfs = new BfsTraversal<>(g);
        bfs.traverse(start);
        if (!bfs.marked.contains(end)) {
            return Collections.emptyList();
        }
        V p = end;
        Deque<V> stack = new ArrayDeque<>();
        stack.push(p);
        while ((p = bfs.parents.get(p)) != null) {
            stack.push(p);
        }
        return new ArrayList<>(stack);
    }

    public static <V, E> boolean hasCycle(Graph<V, E> g) {
        CycleDetector<V, E> detector = new CycleDetector<>(g);
        for (V v : g.getVertices()) {
            if (!detector.marked.contains(v)) {
                detector.traverse(v);
            }
        }
        return detector.hasCycle;
    }

    private static class ComponentsFinder<V, E> extends DfsTraversal<V, E> {
        private int count;
        private final Map<V, Integer> components;
        public ComponentsFinder(Graph<V, E> g, int count) {
            super(g);
            this.count = count;
            this.components = new HashMap<>();
        }

        @Override
        void preProcessVertex(V v) {
            components.put(v, count);
        }
    }

    private static class CycleDetector<V, E> extends DfsTraversal<V, E> {
        private boolean hasCycle = false;
        public CycleDetector(Graph<V, E> g) {
            super(g);
        }

        @Override
        void processEdge(V u, V v) {
            if (marked.contains(v) && parents.get(v) != u) {
                hasCycle = true;
            }
        }
    }

}
