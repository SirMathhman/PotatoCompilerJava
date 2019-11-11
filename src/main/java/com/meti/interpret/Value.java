package com.meti.interpret;

public interface Value<T> extends Statement {
	Type type();
	T value();
}
