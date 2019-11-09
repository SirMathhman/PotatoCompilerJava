package com.meti.lexeme.match.format;

import com.meti.lexeme.match.Match;

class ListMatch implements Match<Void> {
	@Override
	public Void value() {
		return null;
	}

	@Override
	public String toString() {
		return "ListMatch";
	}
}
