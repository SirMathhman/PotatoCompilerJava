package com.meti.lexeme.match;

class StringMatch implements Match<String> {
	private final String value;

	StringMatch(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}

	@Override
	public String toString() {
		return "StringMatch{" +
				"value='" + value + '\'' +
				'}';
	}
}
