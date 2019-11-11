package com.meti.assemble;

public class IfElseNode implements AssemblyNode {
    private final AssemblyNode condition;
    private final AssemblyNode ifBlock;
    private final AssemblyNode elseBlock;

    IfElseNode(AssemblyNode condition, AssemblyNode ifBlock, AssemblyNode elseBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
    }

    public AssemblyNode condition() {
        return condition;
    }

    public AssemblyNode ifBlock() {
        return ifBlock;
    }

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
