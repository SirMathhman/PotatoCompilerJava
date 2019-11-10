package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.OptionalInt;

public class ListAssemblyState implements AssemblyState {
	private final Assembler assembler;
	private final List<? extends Match<?>> matches;

	public ListAssemblyState(List<? extends Match<?>> matches, Assembler assembler) {
		this.matches = matches;
		this.assembler = assembler;
	}

	@Override
	public OptionalInt first(Class<?> clazz) {
		for (int i = 0; i < matches.size(); i++) {
			if (clazz.isAssignableFrom(matches.get(i).getClass())) {
				return OptionalInt.of(i);
			}
		}
		return OptionalInt.empty();
	}

	@Override
	public <T> T get(int index, Class<T> clazz) {
		return clazz.cast(matches.get(index));
	}

	@Override
	public boolean has(int index, Class<?> clazz) {
		return clazz.isAssignableFrom(matches.get(index).getClass());
	}

	@Override
	public boolean has(Class<?> clazz) {
		return matches.stream()
				.map(Object::getClass)
				.anyMatch(clazz::isAssignableFrom);
	}

	@Override
	public Assembler parent() {
		return assembler;
	}

	@Override
	public int size() {
		return matches.size();
	}

	@Override
	public AssemblyState sub(int index) {
		return new ListAssemblyState(matches.subList(index, matches.size()), assembler);
	}

	@Override
	public AssemblyState sub(int fromInclusive, int toExclusive) {
		return new ListAssemblyState(matches.subList(fromInclusive, toExclusive), assembler);
	}
}
