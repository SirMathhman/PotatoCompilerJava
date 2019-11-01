package com.meti;

import java.util.Locale;
import java.util.Optional;

class KeywordTokenBuilder implements TokenBuilder{
	@Override
	public Optional<Token> build(LexerState lexerState) {
		try {
			String value = lexerState.compute().toUpperCase(Locale.ENGLISH);
			return Optional.of(KeywordToken.valueOf(value));
		} catch (IllegalArgumentException e) {
			return Optional.empty();
		}
	}
}
