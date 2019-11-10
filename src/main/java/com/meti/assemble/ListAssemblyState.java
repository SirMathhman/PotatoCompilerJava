package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;

public class ListAssemblyState implements AssemblyState {
	private final Assembler assembler;
	private final List<? extends Match<?>> matches;

	public ListAssemblyState(List<? extends Match<?>> matches, Assembler assembler) {
		this.matches = matches;
		this.assembler = assembler;
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
}
