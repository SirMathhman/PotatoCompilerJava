package com.meti;

class InlineToken<T> implements Token<T> {
	private final T mutable;

	InlineToken(T mutable) {
		this.mutable = mutable;
	}

	@Override
	public T value() {
		return mutable;
	}
}
