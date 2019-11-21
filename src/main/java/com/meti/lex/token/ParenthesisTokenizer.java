package com.meti.lex.token;

import com.meti.lex.LexerInput;

import java.util.Optional;

public class ParenthesisTokenizer implements Tokenizer<Boolean> {
	@Override
	public Optional<? extends Token<Boolean>> match(LexerInput input) {
		var value = input.compute();
		return value.equals("(") || value.equals(")") ?
				Optional.of(new ParenthesisToken(value.equals("("))) :
				Optional.empty();
	}
}
