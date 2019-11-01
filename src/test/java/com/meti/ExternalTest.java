package com.meti;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class ExternalTest {
	@Test
	void parse() {
		var text = "single Internal={extern print[string value]}";
		var lexer = PotatoLexer.PotatoLexer;
		var tokens = lexer.parse(text)
				.stream()
				.map(Match::getClass)
				.collect(Collectors.toList());
		assertIterableEquals(List.of(
				KeywordMatch.class,
				InlineMatch.class,
				BlockMatch.class,
				KeywordMatch.class,
				InlineMatch.class,
				ArgumentMatch.class,
				BlockMatch.class
		), tokens);
	}
}
