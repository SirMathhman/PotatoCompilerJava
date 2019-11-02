package com.meti.assemble;

import com.meti.lexeme.match.Match;

import java.util.List;
import java.util.Optional;

interface AssemblerState {
	Assembler assembler();

	Optional<Integer> find(Class<? extends Match> clazz);

	List<Integer> findAll(Class<? extends Match> clazz);

	<T extends Match> T get(int index, Class<T> clazz);

	boolean has(int index, Class<? extends Match> clazz);

	boolean has(Class<? extends Match> clazz);

	int size();

	List<? extends Match> slice(int from, int to);

	<T> List<T> slice(int from, int to, Class<? extends T> clazz);
}