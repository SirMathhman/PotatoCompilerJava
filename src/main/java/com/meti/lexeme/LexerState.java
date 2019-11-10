package com.meti.lexeme;

import java.util.Optional;

public interface LexerState {
	void advance();

	String compute();

	int depth();

	boolean hasMoreCharacters();

	void reset();

	void sink();

	void skipWhitespace();

	void surface();

	String trailing(int count);

	Optional<Character> trailing();
}
