package com.meti.interpret.statement;

import java.util.List;

public class BlockStatement implements Statement {
	private final List<Statement> statements;

	public BlockStatement(List<Statement> statements) {
		this.statements = statements;
	}

	public List<Statement> children() {
		return statements;
	}
}
