package com.meti.assemble;

import java.util.List;

class SimpleNode implements AssemblyNode {
    private final List<? extends AssemblyNode> children;

    SimpleNode(List<? extends AssemblyNode> children) {
        this.children = children;
    }

    @Override
    public List<? extends AssemblyNode> children() {
        return children;
    }
}
