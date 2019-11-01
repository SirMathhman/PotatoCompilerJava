package com.meti;

import java.util.Locale;
import java.util.Optional;

class KeywordMatcher implements Matcher {
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
