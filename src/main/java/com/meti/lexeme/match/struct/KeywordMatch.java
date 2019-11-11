package com.meti.lexeme.match.struct;

import com.meti.lexeme.match.Match;

public class KeywordMatch implements Match<Keyword> {
	private final Keyword value;

	KeywordMatch(Keyword value) {
		this.value = value;
	}

	@Override
	public Keyword value() {
		return value;
	}
}
