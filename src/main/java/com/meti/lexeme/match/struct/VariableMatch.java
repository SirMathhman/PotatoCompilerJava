package com.meti.lexeme.match.struct;

import com.meti.lexeme.match.Match;

public class VariableMatch implements Match<Boolean> {
	private final boolean mutable;

	VariableMatch(boolean mutable) {
		this.mutable = mutable;
	}

	@Override
	public String toString() {
		return "VariableMatch{" +
				"mutable=" + mutable +
				'}';
	}

	@Override
	public Boolean value() {
		return mutable;
	}
}
