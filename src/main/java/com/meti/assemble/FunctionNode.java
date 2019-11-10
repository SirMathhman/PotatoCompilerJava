package com.meti.assemble;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FunctionNode implements AssemblyNode {
	private final String name;
	private final Map<String, String> parameters;
	private final List<AssemblyNode> content;

	FunctionNode(String name, Map<String, String> parameters, List<AssemblyNode> content) {
		this.name = name;
		this.parameters = parameters;
		this.content = content;
	}

	@Override
	public String toString() {
		var contentString = content.stream()
				.map(AssemblyNode::format)
				.map(value -> "\n\t" + value)
				.collect(Collectors.joining());
		return "FunctionNode{" +
				"name='" + name + '\'' +
				", parameters=" + parameters +
				", content=" + contentString +
				'}';
	}
}
