package com.meti.assemble.node;

import java.util.Map;
import java.util.Optional;

public class FunctionNode implements Node {
	private final Node content;
	private final String name;
	private final Map<String, String> parameterMap;
	private final String returnType;

	public FunctionNode(String name, Map<String, String> parameterMap, String returnType, Node content) {
		this.name = name;
		this.parameterMap = parameterMap;
		this.returnType = returnType;
		this.content = content;
	}

	public Node content() {
		return content;
	}

	public String name() {
		return name;
	}

	public Map<String, String> parameters() {
		return parameterMap;
	}

	public Optional<String> returnType() {
		return Optional.ofNullable(returnType);
	}
}
