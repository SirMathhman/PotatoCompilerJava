package com.meti.lexeme.match.format;

import com.meti.lexeme.match.Match;

public class SeparatorMatch implements Match<Void> {
	@Override
	public Void value() {
		return null;
	}

	@Override
	public String toString() {
		return "SeparatorMatch";
	}
}
