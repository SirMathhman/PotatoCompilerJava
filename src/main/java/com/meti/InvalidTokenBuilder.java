package com.meti;

import java.util.Optional;

class InvalidTokenBuilder implements TokenBuilder {
	@Override
	public Optional<Token> build(LexerState lexerState) {
		if (lexerState.hasTerminated()) {
			throw new CompileException("Cannot parse syntax: " + lexerState.compute());
		} else {
			return Optional.empty();
		}
	}
}
