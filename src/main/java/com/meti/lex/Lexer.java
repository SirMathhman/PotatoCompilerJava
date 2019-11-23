package com.meti.lex;

public interface Lexer<T> {
	LexerOutput<T> lexise(LexerInput lexerInput);
}
