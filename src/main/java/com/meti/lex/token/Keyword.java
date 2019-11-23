package com.meti.lex.token;

public enum Keyword implements Valued<String> {
    IF("if"),
	RETURN("return");

	private final String value;

	Keyword(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}
}
