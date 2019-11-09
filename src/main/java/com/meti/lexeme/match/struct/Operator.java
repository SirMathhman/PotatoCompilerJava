package com.meti.lexeme.match.struct;

public enum Operator implements Valued {
	ADD("+"),
	SUBTRACT("-"),
	MULTIPLY("*"),
	DIVIDE("/"),
	EQUALS("=");

	private final String value;

	Operator(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}
}
