package com.meti.interpret.statement;

public class FunctionStatement implements Statement {
	private final Statement content;
	private final String name;

	public FunctionStatement(String name, Statement content) {
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
