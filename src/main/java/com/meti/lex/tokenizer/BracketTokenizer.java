package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

public class BracketTokenizer implements Tokenizer<Boolean> {
	private final Binding<Integer> depth;

	public BracketTokenizer(Binding<Integer> depth) {
		this.depth = depth;
	}

	@Override
	public Optional<? extends Token<Boolean>> match(LexerInput input) {
		var value = input.compute();
		if (value.equals("{") || value.equals("}")) {
			if (value.equals("{")) {
				depth.set(depth.get() + 1);
			} else {
				depth.set(depth.get() - 1);
			}
            return Optional.of(new InlineToken<>(TokenType.BRACKET, value.equals("{")));
		} else {
			return Optional.empty();
		}
	}
}
