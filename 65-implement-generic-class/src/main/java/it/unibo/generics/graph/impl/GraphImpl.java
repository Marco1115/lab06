package it.unibo.generics.graph.impl;

import java.util.List;
import java.util.Set;

import it.unibo.generics.graph.api.Graph;

class GraphImpl<N> implements Graph<N> {

    private final Set<N> nodesSet;
    private final Map<N, Set<N>> edgesMap;

    @Override
    public void addNode(final N node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addNode'");
    }

    @Override
    public void addEdge(final N source, final N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addEdge'");
    }

    @Override
    public Set<N> nodeSet() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'nodeSet'");
    }

    @Override
    public Set<N> linkedNodes(final N node) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'linkedNodes'");
    }

    @Override
    public List<N> getPath(final N source, final N target) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPath'");
    }

}