package com.meti.lexeme.match;

class StringMatch implements PrimitiveMatch {
	private final String value;

	StringMatch(String value) {
		this.value = value;
	}

	@Override
	public String type(){
		return "string";
	}

	@Override
	public String value() {
		return value;
	}
}
