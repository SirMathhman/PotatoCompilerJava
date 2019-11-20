package com.meti.assemble;

class IntegerNode implements ValueNode<Integer> {
    private final int value;

    IntegerNode(int value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }
}
