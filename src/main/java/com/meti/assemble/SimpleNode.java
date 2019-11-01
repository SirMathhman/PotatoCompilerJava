package com.meti.assemble;

import java.util.List;
import java.util.Objects;

class SimpleNode implements AssemblyNode {
    private final List<? extends AssemblyNode> children;

    SimpleNode(List<? extends AssemblyNode> children) {
        this.children = children;
    }

    @Override
    public List<? extends AssemblyNode> children() {
        return children;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleNode that = (SimpleNode) o;
        return Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }
}
