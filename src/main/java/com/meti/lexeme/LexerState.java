package com.meti.lexeme;

import java.util.Optional;

public interface LexerState {
	void advance();

	String compute();

	boolean hasMoreCharacters();

	void reset();

	void skipWhitespace();

	String trailing(int count);

	Optional<Character> trailing();
}
