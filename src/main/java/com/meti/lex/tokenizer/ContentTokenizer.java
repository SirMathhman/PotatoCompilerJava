package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

public class ContentTokenizer implements Tokenizer<String> {
	@Override
	public Optional<? extends Token<String>> match(LexerInput input) {
		var trailing = input.trailing();
		var value = input.compute();
		if (!value.startsWith("\"")) {
			return trailing.isPresent() && (Character.isAlphabetic(trailing.get()) || Character.isDigit(trailing.get())) ?
					Optional.empty() :
					Optional.of(new InlineToken<>(TokenType.CONTENT, value));
		} else {
			if(value.equals("\"")) return Optional.empty();
			while (!value.endsWith("\"")) {
				try {
					input.extend();
				} catch (IllegalStateException e) {
					throw new IllegalArgumentException("No closing \" was found.", e);
				}
				value = input.compute();
			}
			return Optional.of(new InlineToken<>(TokenType.CONTENT, value));
		}
	}
}