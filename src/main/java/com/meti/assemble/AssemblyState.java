package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.OptionalInt;

public interface AssemblyState {
	default AssemblyNode assemble(AssemblyState state1) {
		return parent().assemble(state1);
	}

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
		return size() > 0 && has(0, clazz);
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

	<T extends Match<?>> List<List<T>> splitByMatch(Class<?> clazz, Class<? extends T> contentMatchClass);

	AssemblyState sub(int index);

	AssemblyState sub(int fromInclusive, int toExclusive);
}
