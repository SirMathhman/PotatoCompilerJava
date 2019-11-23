package com.meti.interpret.statement;

public class QuantityStatement implements Statement {
	private final Statement child;

	public QuantityStatement(Statement child) {
		this.child = child;
	}

	public Statement child() {
		return child;
	}
}
