package com.meti.assemble.node;

public class IndexNode implements Node {
	private final Node array;
	private final Node index;

	public IndexNode(Node array, Node index) {
		this.array = array;
		this.index = index;
	}

	public Node name() {
		return array;
	}

	public Node index() {
		return index;
	}
}
