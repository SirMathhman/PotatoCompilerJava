package com.meti.assemble;

class IfNode implements AssemblyNode {
    private final AssemblyNode condition;
    private final AssemblyNode block;

    IfNode(AssemblyNode condition, AssemblyNode block) {
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
