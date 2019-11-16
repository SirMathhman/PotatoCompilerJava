package com.meti.token;

import com.meti.lex.LexerInput;

import java.util.Optional;

public interface Tokenizer<T> {
	Optional<? extends Token<T>> match(LexerInput input);
}
