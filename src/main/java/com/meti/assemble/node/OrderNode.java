package com.meti.assemble.node;

public class OrderNode implements Node {
	private final Node child;

	public OrderNode(Node child) {
		this.child = child;
	}

	public Node child() {
		return child;
	}
}
