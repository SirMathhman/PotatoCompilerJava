package com.meti.assemble.node.control;

import com.meti.assemble.node.AssemblyNode;

public class InlineIfNode implements IfNode {
    private final AssemblyNode condition;
    private final AssemblyNode block;

    public InlineIfNode(AssemblyNode condition, AssemblyNode block) {
        this.condition = condition;
        this.block = block;
    }

    @Override
    public String toString() {
        return "IfNode{" +
                "condition=" + condition +
                ", block=\n\t" + block +
                "\n}";
    }
}
