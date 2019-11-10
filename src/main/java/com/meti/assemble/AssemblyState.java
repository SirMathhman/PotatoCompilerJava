package com.meti.assemble;

import java.util.OptionalInt;

public interface AssemblyState {
	OptionalInt first(Class<?> clazz);

	<T> T get(int index, Class<T> clazz);

	boolean has(int index, Class<?> clazz);

	boolean has(Class<?> clazz);

	default boolean isSingle() {
		return size() == 1;
	}

	Assembler parent();

	int size();

	AssemblyState sub(int index);

	AssemblyState sub(int fromInclusive, int toExclusive);
}
