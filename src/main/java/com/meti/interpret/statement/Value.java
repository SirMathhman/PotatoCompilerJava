package com.meti.interpret.statement;

import com.meti.interpret.type.Type;

public interface Value<T> extends Statement {
	Type type();
	T value();
}
