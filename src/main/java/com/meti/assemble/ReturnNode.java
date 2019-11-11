package com.meti.assemble;

class ReturnNode implements AssemblyNode {
    private final AssemblyNode value;

    ReturnNode(AssemblyNode value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "ReturnNode{" +
                "value=" + value +
                '}';
    }
}
