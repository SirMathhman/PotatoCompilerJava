package com.meti.assemble;

class BooleanNode implements AssemblyNode {
    private final boolean value;

    BooleanNode(boolean value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "BooleanNode{" +
                "value=" + value +
                '}';
    }
}
