package com.meti.assemble;

public class VariableNode implements AssemblyNode {
	private final String name;

	VariableNode(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "VariableNode{" +
				"name='" + name + '\'' +
				'}';
	}

	public String name() {
		return name;
	}
}
