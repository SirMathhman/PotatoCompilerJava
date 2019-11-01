package com.meti.compile;

import com.meti.assemble.AssemblyNode;

import java.util.List;
import java.util.Optional;

public interface Compiler {
	String compile(AssemblyNode node);

	String compileAll(List<? extends AssemblyNode> children);

	List<String> depth();

	Generator generator();

	Optional<Function> get(List<String> name);

	void put(String name, Function function);
}
