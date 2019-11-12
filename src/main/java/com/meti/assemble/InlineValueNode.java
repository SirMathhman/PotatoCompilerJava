package com.meti.assemble;

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
