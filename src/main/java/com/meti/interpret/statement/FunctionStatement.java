package com.meti.interpret.statement;

import com.meti.interpret.Type;

import java.util.Map;

public class FunctionStatement implements Statement {
	private final Statement content;
	private final String name;
	private final Map<String, Type> parameters;
	private final Type returnType;

	public FunctionStatement(String name, Map<String, Type> parameters, Type returnType, Statement content) {
		this.name = name;
		this.parameters = parameters;
		this.returnType = returnType;
		this.content = content;
	}

	public Statement content() {
		return content;
	}

	public Type getReturnType() {
		return returnType;
	}

	public String name() {
		return name;
	}

	public Map<String, Type> parameters() {
		return parameters;
	}
}
