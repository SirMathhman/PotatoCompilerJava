package com.meti.assemble.node;

import java.util.Map;

public class FunctionNode implements Node {
	private final Map<String, String> parameterMap;
	private final Node content;
	private final String name;

	public FunctionNode(String name, Map<String, String> parameterMap, Node content) {
		this.name = name;
		this.parameterMap = parameterMap;
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
}
