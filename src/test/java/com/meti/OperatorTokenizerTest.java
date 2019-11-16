package com.meti;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTokenizerTest {
	@Test
	void match() {
		var string = "+";
		var tokenizer = new OperatorTokenizer();
		var result = tokenizer.match(string);
		assertTrue(result.isPresent());
		assertEquals(Operator.ADD, result.get().value());
	}

	private static class OperatorTokenizer implements Tokenizer<Token<Valued<Character>>> {
		private final Map<Character, Valued<Character>> map = Arrays.stream(Operator.values())
				.collect(Collectors.toMap(Valued::value, Function.identity()));

		@Override
		public Optional<? extends Token<Valued<Character>>> match(String string) {
			return string.length() == 1 ?
					Optional.ofNullable(map.get(string.charAt(0))).map(InlineToken::new) :
					Optional.empty();
		}
	}
}
