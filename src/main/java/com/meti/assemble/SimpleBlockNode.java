package com.meti.assemble;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

public class SimpleBlockNode implements BlockNode {
	private final String name;
	private final Set<Modifier> modifiers;
	private final Map<String, Type> arguments;
	private final List<? extends AssemblyNode> children;

	SimpleBlockNode(String name, Set<Modifier> modifiers, Map<String, Type> arguments, List<? extends AssemblyNode> children) {
		this.name = name;
		this.modifiers = modifiers;
		this.arguments = arguments;
		this.children = children;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public Set<Modifier> modifiers() {
		return modifiers;
	}

	@Override
	public Map<String, Type> parameters() {
		return arguments;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SimpleBlockNode blockNode = (SimpleBlockNode) o;
		return Objects.equals(name, blockNode.name) &&
				Objects.equals(modifiers, blockNode.modifiers) &&
				Objects.equals(arguments, blockNode.arguments) &&
				Objects.equals(children, blockNode.children);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, modifiers, arguments, children);
	}

	@Override
	public List<? extends AssemblyNode> children() {
		return children;
	}
}