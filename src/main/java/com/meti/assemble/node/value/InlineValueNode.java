package com.meti.assemble.node.value;

import com.meti.assemble.node.value.ValueNode;

abstract class InlineValueNode<T> implements ValueNode<T> {
    protected final T value;

    InlineValueNode(T value) {
        this.value = value;
    }

    @Override
    public T value() {
        return value;
    }
}
