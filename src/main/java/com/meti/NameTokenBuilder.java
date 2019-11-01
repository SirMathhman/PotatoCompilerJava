package com.meti;

import java.util.Optional;

class NameTokenBuilder implements TokenBuilder {
	@Override
	public Optional<Token> build(LexerState lexerState) {
		if (lexerState.trailing(1).equals("[")) {
			return Optional.of(new InlineToken(lexerState.compute()));
		} else {
			return Optional.empty();
		}
	}
}
