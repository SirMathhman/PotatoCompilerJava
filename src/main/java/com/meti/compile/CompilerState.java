package com.meti.compile;

public interface CompilerState {
	default String alias(String key) {
		if (!has(key)) {
			put(key, generator().next());
		}
		return get(key);
	}

	boolean has(String key);

	void put(String key, String value);

	Generator generator();

	String get(String key);
}
