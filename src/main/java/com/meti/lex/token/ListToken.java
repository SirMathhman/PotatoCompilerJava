package com.meti.lex.token;

public class ListToken implements Token<Boolean> {
	private final boolean value;

	public ListToken(boolean value) {
		this.value = value;
	}

	@Override
	public TokenType type() {
		return TokenType.LIST;
	}

	@Override
	public Boolean value() {
		return value;
	}
}
