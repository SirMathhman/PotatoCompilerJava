package com.meti.assemble;

import com.meti.lexeme.match.struct.Keyword;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class FunctionNode implements AssemblyNode {
	private final String name;
	private final List<Keyword> keywords;
	private final Map<String, String> parameters;
	private final List<AssemblyNode> content;
	private final boolean isAbstract;

	FunctionNode(String name, List<Keyword> keywords, Map<String, String> parameters, List<AssemblyNode> content,
	             boolean isAbstract) {
		this.name = name;
		this.keywords = keywords;
		this.parameters = parameters;
		this.content = content;
		this.isAbstract = isAbstract;
	}

	@Override
	public String toString() {
		var contentString = content.stream()
				.map(AssemblyNode::format)
				.map(value -> "\n\t" + value)
				.collect(Collectors.joining());
		return "FunctionNode{" +
				"name='" + name + '\'' +
				"keywords='" + keywords + '\'' +
				", parameters=" + parameters +
				", content=" + contentString +
				'}';
	}
}
