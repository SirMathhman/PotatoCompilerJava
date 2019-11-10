package com.meti.assemble;

class StringNode implements AssemblyNode {
	private final String value;

	StringNode(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "StringNode{" +
				"value='" + value + '\'' +
				'}';
	}
}
