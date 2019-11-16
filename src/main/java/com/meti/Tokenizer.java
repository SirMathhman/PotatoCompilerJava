package com.meti;

import java.util.Optional;

public interface Tokenizer<M> {
	Optional<? extends M> match(String string);
}
