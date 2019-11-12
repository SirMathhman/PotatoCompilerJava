package com.meti.lexeme.match.struct;

import com.meti.lexeme.match.Match;

public class BlockMatch implements Match<Boolean> {
	private final boolean opening;

	BlockMatch(boolean opening) {
		this.opening = opening;
	}

	@Override
	public String toString() {
		return "BlockMatch{" +
				"opening=" + opening +
				'}';
	}

	@Override
	public Boolean value() {
		return opening;
	}
}
