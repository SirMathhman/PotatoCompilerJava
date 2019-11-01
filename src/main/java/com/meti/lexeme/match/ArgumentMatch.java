package com.meti.lexeme.match;

import java.util.Map;

public class ArgumentMatch implements StringMatch {
	private final Map<String, String> types;

	ArgumentMatch(Map<String, String> types) {
		this.types = types;
	}

	@Override
	public String value() {
		return null;
	}
}
