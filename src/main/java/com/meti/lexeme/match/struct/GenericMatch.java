package com.meti.lexeme.match.struct;

import com.meti.lexeme.match.Match;

class GenericMatch implements Match<Boolean> {
	private final boolean opening;

	GenericMatch(boolean opening) {
		this.opening = opening;
	}

	@Override
	public Boolean value() {
		return opening;
	}
}
