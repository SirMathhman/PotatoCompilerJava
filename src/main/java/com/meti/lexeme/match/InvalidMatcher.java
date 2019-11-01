package com.meti.lexeme.match;

import com.meti.CompileException;
import com.meti.lexeme.LexerState;

import java.util.Optional;

public class InvalidMatcher implements Matcher {
	@Override
	public Optional<Match> build(LexerState lexerState) {
		if (lexerState.hasTerminated()) {
			throw new CompileException("Cannot parse syntax: " + lexerState.compute());
		} else {
			return Optional.empty();
		}
	}
}
