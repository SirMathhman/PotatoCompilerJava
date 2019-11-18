package com.meti.assemble;

class IntNode implements ValueNode<Integer> {
    private final int value;

    IntNode(int value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
