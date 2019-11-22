package com.meti.interpret.statement;

import com.meti.interpret.Type;

import java.util.Map;

public class FunctionStatement implements Statement {
	private final Statement content;
	private final String name;

	public FunctionStatement(String name, Map<String, Type> parameterMap, Statement content) {
		this.name = name;
		this.content = content;
	}

	public Statement content() {
		return content;
	}

	public String name() {
		return name;
	}
}
