package com.meti.assemble.node.control;

import com.meti.assemble.node.AssemblyNode;

public class InlineIfElseNode implements IfElseNode {
    private final AssemblyNode condition;
    private final AssemblyNode ifBlock;
    private final AssemblyNode elseBlock;

    InlineIfElseNode(AssemblyNode condition, AssemblyNode ifBlock, AssemblyNode elseBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    @Override
    public AssemblyNode condition() {
        return condition;
    }

    @Override
    public AssemblyNode ifBlock() {
        return ifBlock;
    }

    @Override
    public AssemblyNode elseBlock() {
        return elseBlock;
    }

    @Override
    public String toString() {
        return "IfElseNode{" +
                "condition=" + condition +
                ", \n\tif=" + ifBlock +
                ", \n\telse=" + elseBlock +
                "\n}";
    }
}
