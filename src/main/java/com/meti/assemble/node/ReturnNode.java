package com.meti.assemble.node;

public class ReturnNode implements Node {
	private final Node value;

	public ReturnNode(Node value) {
		this.value = value;
	}

	public Node value() {
		return value;
	}
}
