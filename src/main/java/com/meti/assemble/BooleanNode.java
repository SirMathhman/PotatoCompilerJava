package com.meti.assemble;

class BooleanNode extends InlineValueNode<Boolean> {
    BooleanNode(Boolean value) {
        super(value);
    }

    @Override
    public String toString() {
        return "BooleanNode{" +
                "value=" + value +
                '}';
    }
}
