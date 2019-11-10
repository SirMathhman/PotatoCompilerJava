package com.meti.assemble;

class IfElseNode implements AssemblyNode {
    private final AssemblyNode condition;
    private final AssemblyNode ifBlock;
    private final AssemblyNode elseBlock;

    IfElseNode(AssemblyNode condition, AssemblyNode ifBlock, AssemblyNode elseBlock) {
        this.condition = condition;
        this.ifBlock = ifBlock;
        this.elseBlock = elseBlock;
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
