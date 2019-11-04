package com.meti.lexeme.match;

import java.util.Map;

public class ParameterMatch implements MapMatch<String, String> {
	private final Map<String, String> types;

	ParameterMatch(Map<String, String> types) {
		this.types = types;
	}

	@Override
	public Map<String, String> map() {
		return types;
	}
}
