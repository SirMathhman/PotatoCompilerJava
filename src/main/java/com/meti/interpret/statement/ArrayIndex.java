package com.meti.interpret.statement;

import com.meti.interpret.statement.Statement;

public class ArrayIndex implements Statement {
	private final Statement content;
	private final Statement index;

	public Statement content() {
		return content;
	}

	public Statement getIndex() {
		return index;
	}

	public ArrayIndex(Statement content, Statement index) {
		this.content = content;
		this.index = index;
	}
}
