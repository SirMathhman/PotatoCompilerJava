package com.meti.assemble;

import java.util.List;

class InvocationNode implements AssemblyNode {
	private final List<String> caller;
	private final List<AssemblyNode> values;

	InvocationNode(List<String> caller, List<AssemblyNode> values) {
		this.caller = caller;
		this.values = values;
	}

	@Override
	public String toString() {
		return "InvocationNode{" +
				"caller=" + caller +
				", values=" + values +
				'}';
	}
}
