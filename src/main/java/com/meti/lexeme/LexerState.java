package com.meti.lexeme;

import java.util.Optional;

public interface LexerState {
	LexerState extend();

	String compute();

	Depth depth();

	boolean canParseMore();

	LexerState advance();

	LexerState skipWhitespace();

	String trailing(int count);

	Optional<Character> trailing();
}
