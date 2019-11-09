package com.meti.lexeme.match;

class ContentMatch implements Match<String> {
	private final String value;

	ContentMatch(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "ContentMatch{" +
				"value='" + value + '\'' +
				'}';
	}

	@Override
	public String value() {
		return value;
	}
}
