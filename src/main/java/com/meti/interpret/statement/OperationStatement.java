package com.meti.interpret.statement;

import com.meti.lex.token.Operator;

public class OperationStatement implements Statement {
	private final Statement s0;
	private final Operator operator;
	private final Statement s1;

	public OperationStatement(Statement s0, Operator operator, Statement s1) {
		this.s0 = s0;
		this.operator = operator;
		this.s1 = s1;
	}

	public Statement s0() {
		return s0;
	}

	public Operator operator() {
		return operator;
	}

	public Statement s1() {
		return s1;
	}
}
