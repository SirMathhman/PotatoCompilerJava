package com.meti.assemble;

import java.util.List;
import java.util.Map;

class FunctionNode implements AssemblyNode {
	private final String name;
	private final Map<Type, String> arguments;
	private final List<? extends AssemblyNode> children;

	FunctionNode(String name, Map<Type, String> arguments, List<? extends AssemblyNode> children) {
		this.name = name;
		this.arguments = arguments;
		this.children = children;
	}

	@Override
	public List<? extends AssemblyNode> children() {
		return children;
	}
}