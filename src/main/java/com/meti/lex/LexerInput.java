package com.meti.lex;

import java.util.Optional;

public interface LexerInput {
	LexerInput advance();

	String compute();

	default LexerInput extend(int count) {
		for (int i = 0; i < count; i++) {
			extend();
		}
		return this;
	}

	LexerInput extend();

	LexerInput skipWhitespace();

	boolean hasMoreToScan();

	default Optional<Character> trailing() {
		return trailing(1).map(s -> s.charAt(0));
	}

	Optional<String> trailing(int count);
}
