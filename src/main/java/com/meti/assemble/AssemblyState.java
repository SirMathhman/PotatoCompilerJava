package com.meti.assemble;

import com.meti.lexeme.match.format.SeparatorMatch;

import java.util.List;
import java.util.OptionalInt;

public interface AssemblyState {
	OptionalInt first(Class<?> clazz);

	default <T> T getFirst(Class<T> clazz) {
		return get(0, clazz);
	}

	<T> T get(int index, Class<T> clazz);

	default <T> T getLast(Class<T> clazz) {
		return get(size() - 1, clazz);
	}

	int size();

	boolean has(Class<?> clazz);

	default boolean hasFirst(Class<?> clazz) {
		return has(0, clazz);
	}

	boolean has(int index, Class<?> clazz);

	default boolean hasLast(Class<?> clazz) {
		return has(size() - 1, clazz);
	}

	default boolean isSingle() {
		return size() == 1;
	}

	Assembler parent();

	List<? extends AssemblyState> split(Class<?> clazz);

	AssemblyState sub(int index);

	AssemblyState sub(int fromInclusive, int toExclusive);
}
