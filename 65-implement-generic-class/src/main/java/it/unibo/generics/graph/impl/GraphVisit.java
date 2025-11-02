package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import it.unibo.generics.graph.api.Graph;

public class GraphVisit<N> {

    private static final int WHITE = 0;
    private static final int GRAY = 1;
    private static final int BLACK = 2;

    private final Graph<N> graph;
    private final Map<N, Integer> colorMap;
    private final Map<N, N> parentMap;
    private final Map<N, Integer> distanceMap;

    public GraphVisit(Graph<N> graph) {
        this.graph = graph;
        this.colorMap = new HashMap<>();
        this.parentMap = new HashMap<>();
        this.distanceMap = new HashMap<>();
    }

    public List<N> getPath(final N source, final N target) {
        this.BFS(source);
        final List<N> path = new LinkedList<>();
        path.add(target);
        N currentNode = target;
        while (parentMap.get(currentNode) != null) {
            path.add(parentMap.get(currentNode));
            currentNode = parentMap.get(currentNode);
        }
        return path.reversed();
    }

    private void BFS(final N source) {
        for(final N node: this.graph.nodeSet()) {
            colorMap.put(node, WHITE);
        }
        colorMap.put(source, GRAY);
        distanceMap.put(source, 0);
        parentMap.put(source, null);
        final Queue<N> queue = new LinkedList<>();
        queue.add(source);
        while (!queue.isEmpty()) {
            final N currentNode = queue.remove();
            for (final N adjacentNode: graph.linkedNodes(currentNode)) {
                if (colorMap.get(adjacentNode) == WHITE) {
                    colorMap.put(adjacentNode, GRAY);
                    distanceMap.put(adjacentNode, distanceMap.get(currentNode) + 1);
                    parentMap.put(adjacentNode, currentNode);
                    queue.add(adjacentNode);
                }
            }
            colorMap.put(currentNode, BLACK);
        }
    }
}
