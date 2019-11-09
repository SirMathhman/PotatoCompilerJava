package com.meti.lexeme.match.primitive;

import com.meti.lexeme.match.Match;

class ArrayMatch implements Match<Boolean> {
	private final boolean opening;

	ArrayMatch(boolean opening) {
		this.opening = opening;
	}

	@Override
	public Boolean value() {
		return opening;
	}

	@Override
	public String toString() {
		return "ArrayMatch{" +
				"opening=" + opening +
				'}';
	}
}
