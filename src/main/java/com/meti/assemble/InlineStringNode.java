package com.meti.assemble;

public class InlineStringNode implements StringNode {
	private final String value;

	InlineStringNode(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "StringNode{" +
				"value='" + value + '\'' +
				'}';
	}

	@Override
	public String value() {
		return value;
	}
}
