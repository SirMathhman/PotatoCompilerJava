package com.meti.compile;

import java.util.HashMap;
import java.util.Map;

class InlineCompilerState implements CompilerState {
	private final Map<String, String> aliases = new HashMap<>();
	private final Generator generator;

	InlineCompilerState(Generator generator) {
		this.generator = generator;
	}

	@Override
	public boolean has(String key) {
		return aliases.containsKey(key);
	}

	@Override
	public void put(String key, String value) {
		aliases.put(key, value);
	}

	@Override
	public Generator generator() {
		return generator;
	}

	@Override
	public String get(String key) {
		return aliases.get(key);
	}
}
