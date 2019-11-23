package com.meti.assemble.node;

import java.util.List;

public class BlockNode implements Node {
    private final List<? extends Node> nodes;

    public BlockNode(List<? extends Node> nodes) {
        this.nodes = nodes;
    }

    public List<? extends Node> nodes() {
        return nodes;
    }
}
