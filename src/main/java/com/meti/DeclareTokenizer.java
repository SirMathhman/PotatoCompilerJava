package com.meti;

import java.util.Optional;

public class DeclareTokenizer implements Tokenizer<Token<Boolean>> {
	@Override
	public Optional<? extends Token<Boolean>> match(String string) {
		return string.equals("var") || string.equals("val") ?
				Optional.of(new InlineToken<>(string.equals("var"))) :
				Optional.empty();
	}
}