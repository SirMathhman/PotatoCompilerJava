package com.meti.assemble;

import java.util.List;

public class InlineInvocationNode implements InvocationNode {
	private final List<String> caller;
	private final List<AssemblyNode> values;

	InlineInvocationNode(List<String> caller, List<AssemblyNode> values) {
		this.caller = caller;
		this.values = values;
	}

	@Override
	public List<String> caller() {
		return caller;
	}

	@Override
	public List<AssemblyNode> values() {
		return values;
	}

	@Override
	public String toString() {
		return "InvocationNode{" +
				"caller=" + caller +
				", values=" + values +
				'}';
	}
}
