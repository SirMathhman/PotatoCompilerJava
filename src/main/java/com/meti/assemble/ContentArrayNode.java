package com.meti.assemble;

import java.util.List;
import java.util.stream.Collectors;

class ContentArrayNode implements AssemblyNode {
	private final List<AssemblyNode> arguments;

	ContentArrayNode(List<AssemblyNode> arguments) {
		this.arguments = arguments;
	}

	@Override
	public String toString() {
		var argString = arguments.stream()
				.map(AssemblyNode::format)
				.map(s -> "\n\t" + s)
				.collect(Collectors.joining(""));
		return "ContentArrayNode{" +
				"arguments=" + argString +
				'}';
	}
}
