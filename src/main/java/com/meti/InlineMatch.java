package com.meti;

class InlineMatch implements Match<Boolean> {
	private final boolean mutable;

	InlineMatch(boolean mutable) {
		this.mutable = mutable;
	}

	@Override
	public Boolean value() {
		return mutable;
	}
}
