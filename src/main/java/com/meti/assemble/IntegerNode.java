package com.meti.assemble;

class IntegerNode implements AssemblyNode {
	private final int value;

	IntegerNode(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "IntegerNode{" +
				"value=" + value +
				'}';
	}
}
