package com.meti.lexeme.match.struct;

import com.meti.lexeme.match.Match;

public class ChildMatch implements Match<Void> {
	@Override
	public Void value() {
		return null;
	}

	@Override
	public String toString() {
		return "ChildMatch";
	}
}
