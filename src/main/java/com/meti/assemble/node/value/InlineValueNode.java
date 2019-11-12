package com.meti.assemble.node.value;

public abstract class InlineValueNode<T> implements ValueNode<T> {
	protected final T value;

    protected InlineValueNode(T value) {
		this.value = value;
	}

	@Override
	public T value() {
		return value;
	}
}
