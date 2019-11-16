package com.meti;

import java.util.Optional;

class IntegerTokenizer implements Tokenizer<Token<Integer>> {
	@Override
	public Optional<? extends Token<Integer>> match(String string) {
		return string.chars().allMatch(Character::isDigit) ?
				Optional.of(new InlineToken<>(Integer.parseInt(string))) :
				Optional.empty();
	}
}
