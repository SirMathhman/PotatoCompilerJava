package com.meti.assemble;

import java.util.List;
import java.util.Objects;

public class GroupNode implements AssemblyNode {
    private final List<? extends AssemblyNode> children;

    GroupNode(List<? extends AssemblyNode> children) {
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
        GroupNode that = (GroupNode) o;
        return Objects.equals(children, that.children);
    }

    @Override
    public int hashCode() {
        return Objects.hash(children);
    }
}
