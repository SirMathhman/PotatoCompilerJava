package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Locale;
import java.util.Optional;

public class KeywordMatcher implements Matcher {
	@Override
	public Optional<Match> build(LexerState lexerState) {
		try {
			String value = lexerState.compute().toUpperCase(Locale.ENGLISH);
			return Optional.of(KeywordMatch.valueOf(value));
		} catch (IllegalArgumentException e) {
			return Optional.empty();
		}
	}
}
