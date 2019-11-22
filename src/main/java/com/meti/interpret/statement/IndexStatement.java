package com.meti.interpret.statement;

public class IndexStatement implements Statement {
	private final Statement index;
	private final Statement name;

	public IndexStatement(Statement name, Statement index) {
		this.name = name;
		this.index = index;
	}

	public Statement index() {
		return index;
	}

	public Statement name() {
		return name;
	}
}
