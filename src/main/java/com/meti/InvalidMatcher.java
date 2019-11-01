package com.meti;

import java.util.Optional;

class InvalidMatcher implements Matcher {
	@Override
	public Optional<Match> build(LexerState lexerState) {
		if (lexerState.hasTerminated()) {
			throw new CompileException("Cannot parse syntax: " + lexerState.compute());
		} else {
			return Optional.empty();
		}
	}
}
