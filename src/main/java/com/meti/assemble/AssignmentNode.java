package com.meti.assemble;

class AssignmentNode implements AssemblyNode {
	private final boolean mutable;
	private final String name;
	private final AssemblyNode value;

	AssignmentNode(String name, boolean mutable, AssemblyNode value) {
		this.name = name;
		this.mutable = mutable;
		this.value = value;
	}

	@Override
	public String toString() {
		return "AssignmentNode{" +
				"name='" + name + '\'' +
				", mutable=" + mutable +
				", value=\n\t" + value + "\n" +
				'}';
	}
}
