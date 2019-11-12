package com.meti.assemble.node.control;

import com.meti.assemble.node.AssemblyNode;

public class InlineReturnNode implements ReturnNode {
    private final AssemblyNode value;

    InlineReturnNode(AssemblyNode value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ReturnNode{" +
                "value=" + value +
                '}';
    }

    @Override
    public AssemblyNode value() {
        return value;
    }
}
