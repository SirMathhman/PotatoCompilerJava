package com.meti.lexeme.match.primitive;

import com.meti.lexeme.match.Match;

public class BooleanMatch implements Match<Boolean> {
	private final boolean value;

	BooleanMatch(boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "BooleanMatch{" +
				"value=" + value +
				'}';
	}

	@Override
	public Boolean value() {
		return value;
	}
}
