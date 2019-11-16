package com.meti.lex;

import java.util.List;

public interface LexerOutput<T> {
	List<? extends T> list();
}
