package com.meti;

public interface LexerState {
	void advance();

	String compute();

	boolean hasMoreCharacters();

	boolean hasTerminated();

	void reset();

	String trailing(int count);
}
