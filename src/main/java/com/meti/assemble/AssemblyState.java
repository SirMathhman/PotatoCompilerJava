package com.meti.assemble;

public interface AssemblyState {
	<T> T get(int index, Class<T> clazz);

	boolean has(int index, Class<?> clazz);

	Assembler parent();

	int size();

	AssemblyState sub(int index);
}
