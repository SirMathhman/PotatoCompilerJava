package com.meti.assemble;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

class BlockNode implements AssemblyNode {
	private final String name;
	private Set<Modifier> modifiers;
	private final Map<Type, String> arguments;
	private final List<? extends AssemblyNode> children;

	BlockNode(String name, Set<Modifier> modifiers, Map<Type, String> arguments, List<? extends AssemblyNode> children) {
		this.name = name;
		this.modifiers = modifiers;
		this.arguments = arguments;
		this.children = children;
	}

	@Override
	public List<? extends AssemblyNode> children() {
		return children;
	}
}