package com.meti.compile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class InlineCompilerState implements CompilerState {
	private final Map<String[], String> aliases = new HashMap<>();
	private final Generator generator;
	private final List<String> name = new ArrayList<>();

	InlineCompilerState(Generator generator) {
		this.generator = generator;
	}

	@Override
	public List<String> name() {
		return name;
	}

	@Override
	public boolean has(String... key) {
		return aliases.containsKey(key);
	}

	@Override
	public void put(String value, String... key) {
		aliases.put(key, value);
	}

	@Override
	public Generator generator() {
		return generator;
	}

	@Override
	public String get(String... key) {
		return aliases.get(key);
	}
}
