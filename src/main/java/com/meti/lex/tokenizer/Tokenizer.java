package com.meti.lex.tokenizer;

import com.meti.lex.LexerInput;
import com.meti.lex.token.Token;

import java.util.Optional;

public interface Tokenizer<T> {
	Optional<? extends Token<T>> match(LexerInput input);
}
