package com.meti.token;

public interface Token<T> {
	default <R> R as(Class<R> clazz) {
		return clazz.cast(value());
	}

	T value();
}
