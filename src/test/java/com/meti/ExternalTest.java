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
				.map(Token::getClass)
				.collect(Collectors.toList());
		assertIterableEquals(List.of(
				KeywordToken.class,
				InlineToken.class,
				BlockToken.class,
				KeywordToken.class,
				InlineToken.class,
				ArgumentToken.class,
				BlockToken.class
		), tokens);
	}
}
