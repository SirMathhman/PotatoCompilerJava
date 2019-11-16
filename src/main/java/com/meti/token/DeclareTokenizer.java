package com.meti.token;

import com.meti.lex.LexerInput;

import java.util.Optional;

public class DeclareTokenizer implements Tokenizer<Boolean> {
	@Override
	public Optional<? extends Token<Boolean>> match(LexerInput input) {
		var value = input.compute();
		return value.equals("var") || value.equals("val") ?
				Optional.of(new InlineToken<>(value.equals("var"))) :
				Optional.empty();
	}
}