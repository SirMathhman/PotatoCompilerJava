package com.meti.assemble.node;

public class AllocNode implements Node {
	private final Node size;

	public AllocNode(Node size) {
		this.size = size;
	}

	public Node size() {
		return size;
	}
}
