package com.meti.lexeme.match;

class StringMatch implements ValuedMatch {
	private final String value;

	StringMatch(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}
}
