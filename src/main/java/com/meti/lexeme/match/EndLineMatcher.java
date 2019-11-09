package com.meti.lexeme.match;

import com.meti.lexeme.LexerState;

import java.util.Optional;

public class EndLineMatcher implements Matcher {
	@Override
	public Optional<Match<?>> build(LexerState state) {
		if (state.compute().equals(";")) return Optional.of(new EndLineMatch());
		else return Optional.empty();
	}
}
