package com.meti;

class SimpleCatcher<T> implements Catcher<T> {
	private final Tryable<T> tryable;

	SimpleCatcher(Tryable<T> tryable) {
		this.tryable = tryable;
	}

	@Override
	public T evaluate(T other) {
		try {
			return tryable.execute();
		} catch (Exception e) {
			return other;
		}
	}
}
