package com.meti.lexeme.match.struct;

import com.meti.lexeme.match.Match;

public class EndLineMatch implements Match<Integer> {
	private final int depth;

	public EndLineMatch(int depth) {
		this.depth = depth;
	}

	@Override
	public Integer value() {
		return depth;
	}

	@Override
	public String toString() {
		return "EndLineMatch{" +
				"depth=" + depth +
				'}';
	}
}
