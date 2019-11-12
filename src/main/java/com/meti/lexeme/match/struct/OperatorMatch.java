package com.meti.lexeme.match.struct;

import com.meti.lexeme.match.Match;

public class OperatorMatch implements Match<Valued> {
	private final Valued operator;

	OperatorMatch(Valued operator) {
		this.operator = operator;
	}

	@Override
	public String toString() {
		return "OperatorMatch{" +
				"operator=" + operator +
				'}';
	}

	@Override
	public Valued value() {
		return operator;
	}
}
