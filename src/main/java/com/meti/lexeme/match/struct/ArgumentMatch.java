package com.meti.lexeme.match.struct;

import com.meti.lexeme.match.Match;

public class ArgumentMatch implements Match<Boolean> {
	private final boolean opening;

	ArgumentMatch(boolean opening) {
		this.opening = opening;
	}

	@Override
	public String toString() {
		return "ArgumentMatch{" +
				"opening=" + opening +
				'}';
	}

	@Override
	public Boolean value() {
		return opening;
	}
}
