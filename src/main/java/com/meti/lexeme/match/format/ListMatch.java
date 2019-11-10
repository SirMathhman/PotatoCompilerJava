package com.meti.lexeme.match.format;

import com.meti.lexeme.match.Match;

public class ListMatch implements Match<Boolean> {
	private final boolean opening;

	ListMatch(boolean opening) {
		this.opening = opening;
	}

	@Override
	public Boolean value() {
		return opening;
	}

	@Override
	public String toString() {
		return "ListMatch{" +
				"opening=" + opening +
				'}';
	}
}
