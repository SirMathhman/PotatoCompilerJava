package com.meti.lex;

import java.util.List;

public interface Lexer {
	List<Lexeme> parse(String value);
}
