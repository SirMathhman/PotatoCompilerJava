package com.meti.compile;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SimpleGenerator implements Generator {
	private static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
	private final Map<String[], String> aliases = new HashMap<>();
	private int counter = -1;

	@Override
	public String alias(String... name) {
		var optional = aliases.keySet().stream()
				.filter(strings -> Arrays.deepEquals(strings, name))
				.map(aliases::get)
				.findAny();
		if (optional.isPresent()) {
			return optional.get();
		} else {
			var next = next();
			aliases.put(name, next);
			return next;
		}
	}

	@Override
	public void reset() {
		counter = -1;
		aliases.clear();
	}

	private String next() {
		counter++;
		return ALPHABET.charAt(counter % ALPHABET.length()) +
				String.valueOf(counter);
	}
}
