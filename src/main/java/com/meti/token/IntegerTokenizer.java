package com.meti.token;

import com.meti.lex.LexerInput;

import java.util.Optional;

public class IntegerTokenizer implements Tokenizer<Integer> {
	@Override
	public Optional<? extends Token<Integer>> match(LexerInput input) {
		return input.compute().chars().allMatch(Character::isDigit) ?
				Optional.of(new InlineToken<>(Integer.parseInt(input.compute()), type)) :
				Optional.empty();
	}
}
