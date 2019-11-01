package com.meti.lexeme.match;

import java.util.Map;

public class ParameterMatch implements Match {
	private final Map<String, String> types;

	ParameterMatch(Map<String, String> types) {
		this.types = types;
	}

	public Map<String, String> map() {
		return types;
	}
}
