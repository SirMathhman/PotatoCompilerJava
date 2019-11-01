package com.meti.compile;

import com.meti.assemble.AssemblyNode;

import java.util.List;

public interface Compiler {
	String compile(AssemblyNode node);

	String compileAll(List<? extends AssemblyNode> children);

	Generator generator();
}
