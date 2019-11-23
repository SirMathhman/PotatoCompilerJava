package com.meti.assemble.node;

public class StringNode implements Node {
	private final String value;

	public StringNode(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
