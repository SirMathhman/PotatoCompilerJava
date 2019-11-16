package com.meti;

import java.util.Optional;

public class ContentTokenizer implements Tokenizer<Token<String>> {

	@Override
	public Optional<? extends Token<String>> match(String string) {
		return Optional.of(new InlineToken<>(string));
	}
}