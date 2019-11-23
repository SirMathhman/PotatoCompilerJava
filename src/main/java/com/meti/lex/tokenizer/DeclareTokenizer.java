package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

public class DeclareTokenizer implements Tokenizer<Boolean> {
	@Override
	public Optional<? extends Token<Boolean>> match(LexerInput input) {
		var value = input.compute();
		var trailing = input.trailing();
		if(trailing.isPresent() && !trailing.get().equals(' ')) return Optional.empty();
		return value.equals("var") || value.equals("val") ?
				Optional.of(new InlineToken<>(TokenType.DECLARE, value.equals("var"))) :
				Optional.empty();
	}
}