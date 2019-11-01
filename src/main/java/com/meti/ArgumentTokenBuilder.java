package com.meti;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

class ArgumentTokenBuilder implements TokenBuilder{
	@Override
	public Optional<Token> build(LexerState lexerState) {
		String value = lexerState.compute();
		if(value.charAt(0) == '[' && value.charAt(value.length() - 1) == ']') {
			Map<String, String> types = Arrays.stream(value.substring(1, value.length() - 1)
					.split(","))
					.map(s -> s.split(" "))
					.collect(Collectors.toMap(strings -> strings[0], strings -> strings[1]));
			return Optional.of(new ArgumentToken(types));
		}
		return Optional.empty();
	}
}
