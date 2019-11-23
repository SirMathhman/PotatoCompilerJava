package com.meti.interpret.evaluate;

import com.meti.interpret.statement.Statement;

public class StringStatement implements Statement {
	private final String value;

	public StringStatement(String value) {
		this.value = value;
	}

	public String value() {
		return value;
	}
}
