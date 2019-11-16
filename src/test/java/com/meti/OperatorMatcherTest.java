package com.meti;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

class OperatorMatcherTest {
	@Test
	void match() {
		var string = "+";
		var matcher = new OperatorMatcher();
		var result = matcher.match(string);
		assertTrue(result.isPresent());
		assertEquals(Operator.ADD, result.get().value());
	}

	private static class OperatorMatcher implements Matcher<Match<Valued<Character>>> {
		private final Map<Character, Valued<Character>> map = Arrays.stream(Operator.values())
				.collect(Collectors.toMap(Valued::value, Function.identity()));

		@Override
		public Optional<? extends Match<Valued<Character>>> match(String string) {
			return string.length() == 1 ?
					Optional.ofNullable(map.get(string.charAt(0))).map(InlineMatch::new) :
					Optional.empty();
		}
	}
}
