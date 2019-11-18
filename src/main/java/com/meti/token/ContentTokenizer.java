package com.meti.token;

import com.meti.lex.LexerInput;

import java.util.Optional;

public class ContentTokenizer implements Tokenizer<String> {
	@Override
	public Optional<? extends Token<String>> match(LexerInput input) {
		var trailing = input.trailing();
		return trailing.isPresent() && Character.isAlphabetic(trailing.get()) ?
				Optional.empty() :
				Optional.of(new InlineToken<>(input.compute(), type));
	}
}