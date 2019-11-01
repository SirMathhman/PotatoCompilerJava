package com.meti;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class ArgumentMatcher implements Matcher {
	@Override
	public Optional<Match> build(LexerState lexerState) {
		String value = lexerState.compute();
		if(value.charAt(0) == '[' && value.charAt(value.length() - 1) == ']') {
			Map<String, String> types = Arrays.stream(value.substring(1, value.length() - 1)
					.split(","))
					.map(s -> s.split(" "))
					.collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));
			return Optional.of(new ArgumentMatch(types));
		}
		return Optional.empty();
	}
}
