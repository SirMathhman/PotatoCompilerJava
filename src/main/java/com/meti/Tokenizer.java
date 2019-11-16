package com.meti;

import java.util.Optional;

public interface Tokenizer<T> {
	Optional<? extends Token<T>> match(LexerInput input);
}
