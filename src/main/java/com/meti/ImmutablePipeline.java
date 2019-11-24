package com.meti;

import java.util.function.Function;

public class ImmutablePipeline<T, R> implements Pipeline<T, R> {
	private final Function<T, ? extends R> root;

	public ImmutablePipeline(Function<T, ? extends R> root) {
		this.root = root;
	}

	@Override
	public <S> Pipeline<T, S> append(Function<? super R, ? extends S> other) {
		return new ImmutablePipeline<>(root.andThen(other));
	}

	@Override
	public R evaluate(T input) {
		return root.apply(input);
	}
}
