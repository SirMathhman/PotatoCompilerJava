package com.meti.assemble;

import java.util.List;

class GroupNode implements Node {
    private final List<? extends Node> children;

    public GroupNode(List<? extends Node> children) {
        this.children = children;
    }
}
