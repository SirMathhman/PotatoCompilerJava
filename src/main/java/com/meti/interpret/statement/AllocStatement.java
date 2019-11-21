package com.meti.interpret.statement;

public class AllocStatement implements Statement {
	private final Statement size;

	public AllocStatement(Statement size) {
		this.size = size;
	}

	public Statement size() {
		return size;
	}
}
