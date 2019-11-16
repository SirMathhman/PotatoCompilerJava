package com.meti.lex;

import java.util.List;

import static java.util.Collections.unmodifiableList;

public class ListLexerOutput<T> implements LexerOutput<T> {
	private final List<? extends T> collection;

	public ListLexerOutput(List<? extends T> collection) {
		this.collection = collection;
	}

	@Override
	public List<? extends T> list() {
		return unmodifiableList(collection);
	}
}
