package com.meti.compile;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

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
		return aliases.keySet()
				.stream()
				.anyMatch(strings -> Arrays.deepEquals(strings, key));
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
		return aliases.keySet()
				.stream()
				.filter(strings -> Arrays.deepEquals(strings, key))
				.map(aliases::get)
				.findAny()
				.orElseThrow();
	}
}
