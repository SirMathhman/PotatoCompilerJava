package com.meti;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.empty;
import static java.util.Optional.of;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class LexerTest {
	private final Lexer lexer = new SequentialLexer(List.of(new OddBuilder(), new EvenBuilder()));

	@Test
	void parse() {
		List<? extends Token> tokens = lexer.parse("563");
		var tokenValues = tokens.stream()
				.map(Token::value)
				.collect(Collectors.toList());
		assertIterableEquals(List.of("odd", "even", "odd"), tokenValues);
	}

	private static final class EvenBuilder implements TokenBuilder {
		@Override
		public Optional<Token> build(LexerState lexerState) {
			Optional<Token> result;
			try {
				int value = Integer.parseInt(lexerState.compute());
				result = value % 2 == 0 ? of(new InlineToken("even")) : empty();
			} catch (NumberFormatException e) {
				result = empty();
			}
			return result;
		}
	}

	private static final class OddBuilder implements TokenBuilder {
		@Override
		public Optional<Token> build(LexerState lexerState) {
			Optional<Token> result;
			try {
				int value = Integer.parseInt(lexerState.compute());
				result = value % 2 != 1 ? empty() : of(new InlineToken("odd"));
			} catch (NumberFormatException e) {
				result = empty();
			}
			return result;
		}
	}
}
