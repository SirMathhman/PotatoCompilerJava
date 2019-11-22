package com.meti.assemble.node;

public class FunctionNode implements Node {
	private final Node content;
	private final String name;

	public FunctionNode(String name, Node content) {
		this.name = name;
		this.content = content;
	}

	public Node content() {
		return content;
	}

	public String name() {
		return name;
	}
}
