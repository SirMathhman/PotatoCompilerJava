package com.meti;

import java.util.Map;

class ArgumentToken implements StringToken {
	private final Map<String, String> types;

	ArgumentToken(Map<String, String> types) {
		this.types = types;
	}

	@Override
	public String value() {
		return null;
	}
}
