package com.meti;

class InlineToken implements Token {
	private final String value;

	InlineToken(String value) {
		this.value = value;
	}

	@Override
	public String value() {
		return value;
	}
}
