package com.meti;

import java.util.Optional;

class BlockTokenBuilder implements TokenBuilder {
	@Override
	public Optional<Token> build(LexerState lexerState) {
		String value = lexerState.compute();
		if(value.equals("={")){
			return Optional.of(new BlockToken());
		} else if(value.equals("}")) {
			return Optional.of(new BlockToken());
		}
		return Optional.empty();
	}
}
