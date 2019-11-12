package com.meti.compile;

import java.util.List;

public interface CompilerState {
	default String alias(String... keys) {
		if (!has(keys)) {
			put(generator().next(), keys);
		}
		return get(keys);
	}

	List<String> name();

	boolean has(String... key);

	void put(String value, String... key);

	Generator generator();

	String get(String... key);
}
