package com.meti.lexeme;

import java.util.Optional;

public interface LexerState {
	LexerState advance();

	String compute();

	Depth depth();

	boolean canParseMore();

	LexerState reset();

	LexerState skipWhitespace();

	String trailing(int count);

	Optional<Character> trailing();
}
