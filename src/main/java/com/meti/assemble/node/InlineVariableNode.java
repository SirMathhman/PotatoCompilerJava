package com.meti.assemble.node;

public class InlineVariableNode implements VariableNode {
	private final String name;

	InlineVariableNode(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "VariableNode{" +
				"name='" + name + '\'' +
				'}';
	}

	@Override
	public String name() {
		return name;
	}
}
