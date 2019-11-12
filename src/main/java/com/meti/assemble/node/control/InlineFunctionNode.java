package com.meti.assemble.node.control;

import com.meti.assemble.node.AssemblyNode;
import com.meti.lexeme.match.struct.Keyword;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class InlineFunctionNode implements FunctionNode {
	private final List<AssemblyNode> content;
	private final List<String> genericBounds;
	private final boolean isAbstract;
	private final Set<Keyword> keywords;
	private final String name;
	private final Map<String, String> parameters;
	private final String returnType;

	public InlineFunctionNode(String name, Set<Keyword> keywords, List<String> genericBounds,
	                          Map<String, String> parameters, String returnType,
	                          List<AssemblyNode> content,
	                          boolean isAbstract) {
		this.name = name;
		this.keywords = keywords;
		this.genericBounds = genericBounds;
		this.parameters = parameters;
		this.returnType = returnType;
		this.content = content;
		this.isAbstract = isAbstract;
	}

	@Override
	public List<String> getGenericBounds() {
		return genericBounds;
	}

	@Override
	public Optional<String> returnType() {
		return Optional.ofNullable(returnType);
	}

	@Override
	public List<AssemblyNode> getContent() {
		return content;
	}

	@Override
	public Set<Keyword> keywords() {
		return keywords;
	}

	@Override
	public String name() {
		return name;
	}

	@Override
	public Map<String, String> getParameters() {
		return parameters;
	}

	@Override
	public boolean isAbstract() {
		return isAbstract;
	}

	@Override
	public String toString() {
		var contentString = content.stream()
				.map(AssemblyNode::format)
				.map(value -> "\n\t" + value)
				.collect(Collectors.joining());
		return "InlineFunctionNode{" +
				"name='" + name + '\'' +
				", parameters=" + parameters +
				", returnType='" + returnType + '\'' +
				", keywords=" + keywords +
				", genericBounds=" + genericBounds +
				", isAbstract=" + isAbstract +
				", content=" + contentString +
				'}';
	}
}
