package com.meti.interpret.statement;

import com.meti.interpret.Type;

import java.util.Map;

public class FunctionStatement implements Statement {
	private final Map<String, Type> parameters;
	private final Statement content;
	private final String name;

	public FunctionStatement(String name, Map<String, Type> parameters, Statement content) {
		this.name = name;
		this.parameters = parameters;
		this.content = content;
	}

	public Map<String, Type> parameters() {
		return parameters;
	}

	public Statement content() {
		return content;
	}

	public String name() {
		return name;
	}
}
