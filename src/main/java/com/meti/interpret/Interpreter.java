package com.meti.interpret;

import com.meti.assemble.AssemblyNode;

public interface Interpreter {
	Function find(String... names);

	void load(AssemblyNode node);

	Statement loadChild(AssemblyNode node);
}