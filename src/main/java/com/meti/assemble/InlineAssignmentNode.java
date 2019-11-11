package com.meti.assemble;

public class InlineAssignmentNode implements AssignmentNode {
	private final boolean mutable;
	private final String name;
	private final AssemblyNode value;

	InlineAssignmentNode(String name, boolean mutable, AssemblyNode value) {
		this.name = name;
		this.mutable = mutable;
		this.value = value;
	}

	@Override
	public boolean isMutable() {
		return mutable;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public AssemblyNode value() {
		return value;
	}

	@Override
	public String toString() {
		return "AssignmentNode{" +
				"name='" + name + '\'' +
				", mutable=" + mutable +
				", value=\n\t" + value.format() + "\n" +
				'}';
	}
}
