package com.meti.lexeme.match.primitive;

import com.meti.lexeme.match.Match;

public class IntegerMatch implements Match<Integer> {
	private final int value;

	IntegerMatch(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "IntegerMatch{" +
				"value=" + value +
				'}';
	}

	@Override
	public Integer value() {
		return value;
	}
}
