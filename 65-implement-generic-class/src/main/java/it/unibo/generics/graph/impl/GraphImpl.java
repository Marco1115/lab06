package it.unibo.generics.graph.impl;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

class GraphImpl<N> implements Graph<N> {

    private final Map<N, Set<N>> edgesMap;

    public GraphImpl(){
        this.edgesMap = new HashMap<>();
    }

    @Override
    public void addNode(final N node) {
        this.edgesMap.put(node, new HashSet<>());
    }

    @Override
    public void addEdge(final N source, final N target) {
        this.edgesMap.get(source).add(target);
    }

    @Override
    public Set<N> nodeSet() {
        return this.edgesMap.keySet();
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        return this.edgesMap.get(node);
    }

    @Override
    public List<N> getPath(final N source, final N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }

}