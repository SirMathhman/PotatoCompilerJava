package com.meti;

class InlineMatch<T> implements Match<T> {
	private final T mutable;

	InlineMatch(T mutable) {
		this.mutable = mutable;
	}

	@Override
	public T value() {
		return mutable;
	}
}
