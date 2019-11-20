package com.meti.assemble.node;

public class IntNode implements ValueNode<Integer> {
    private final int value;

    public IntNode(int value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
