package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public interface Matcher {
	default <T extends Match<?>> Optional<T> build(LexerState state, Class<T> clazz) {
		try {
			return build(state).map(clazz::cast);
		} catch (Exception e) {
			return Optional.empty();
		}
	}

	Optional<Match<?>> build(LexerState state);
}
