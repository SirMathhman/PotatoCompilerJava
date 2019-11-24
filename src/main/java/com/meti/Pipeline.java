package com.meti;

import java.util.function.Function;

public interface Pipeline<T, R> {
	<S> Pipeline<T, S> append(Function<? super R, ? extends S> other);

	R evaluate(T input);
}
