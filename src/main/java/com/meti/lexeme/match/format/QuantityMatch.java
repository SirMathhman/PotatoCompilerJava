package com.meti.lexeme.match.format;

import com.meti.lexeme.match.Match;

class QuantityMatch implements Match<Boolean> {
	private final Boolean value;

	QuantityMatch(Boolean value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "QuantityMatch{" +
				"value=" + value +
				'}';
	}

	@Override
	public Boolean value() {
		return value;
	}
}
