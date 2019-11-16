package com.meti;

public interface Lexer<T> {
	LexerOutput<T> lexise(LexerInput lexerInput);
}
