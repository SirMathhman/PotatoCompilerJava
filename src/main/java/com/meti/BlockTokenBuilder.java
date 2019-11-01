package com.meti;

import java.util.Optional;

class BlockTokenBuilder implements TokenBuilder {
	@Override
	public Optional<Token> build(LexerState lexerState) {
		Optional<Token> result;
		String value = lexerState.compute();
		if (value.equals("={")) {
			result = Optional.of(new BlockToken());
		} else if (value.equals("}")) {
			result = Optional.of(new BlockToken());
		} else {
			result = Optional.empty();
		}
		return result;
	}
}
