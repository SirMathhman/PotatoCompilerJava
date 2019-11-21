package com.meti.assemble.node;

public class QuantityNode implements Node {
	private final Node child;

	public QuantityNode(Node child) {
		this.child = child;
	}

	public Node child() {
		return child;
	}
}
