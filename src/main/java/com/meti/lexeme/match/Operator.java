package com.meti.lexeme.match;

public enum Operator implements Valued {
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
