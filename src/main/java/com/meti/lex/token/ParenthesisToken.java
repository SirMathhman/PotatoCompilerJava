package com.meti.lex.token;

public class ParenthesisToken implements Token<Boolean> {
	private final boolean value;

	public ParenthesisToken(boolean value) {
		this.value = value;
	}

	@Override
	public TokenType type() {
		return TokenType.PARENTHESIS;
	}

	@Override
	public Boolean value() {
		return value;
	}
}
