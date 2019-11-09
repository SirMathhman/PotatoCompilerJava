package com.meti.lexeme.match;

class OperatorMatch implements Match<Valued> {
	private final Valued valued;

	OperatorMatch(Valued valued) {
		this.valued = valued;
	}

	@Override
	public String toString() {
		return "OperatorMatch{" +
				"valued=" + valued +
				'}';
	}

	@Override
	public Valued value() {
		return valued;
	}
}
