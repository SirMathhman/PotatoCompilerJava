package com.meti.assemble.node.value;

public class BooleanNode extends InlineValueNode<Boolean> {
    public BooleanNode(Boolean value) {
        super(value);
    }

    @Override
    public String toString() {
        return "BooleanNode{" +
                "value=" + value +
                '}';
    }
}
