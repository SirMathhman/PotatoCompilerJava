package com.meti;

class SimpleCatcher<T> implements Catcher<T> {
	private final Tryable<? extends T> tryable;

	SimpleCatcher(Tryable<? extends T> tryable) {
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
