package com.meti.assemble.node;

public class IntegerNode implements ValueNode<Integer> {
    private final int value;

    public IntegerNode(int value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
