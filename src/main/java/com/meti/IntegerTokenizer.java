package com.meti;

import java.util.Optional;

class IntegerTokenizer implements Tokenizer<Integer> {
	@Override
	public Optional<? extends Token<Integer>> match(LexerInput input) {
		return input.compute().chars().allMatch(Character::isDigit) ?
				Optional.of(new InlineToken<>(Integer.parseInt(input.compute()))) :
				Optional.empty();
	}
}
