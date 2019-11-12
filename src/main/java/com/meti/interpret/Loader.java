package com.meti.interpret;

import com.meti.assemble.AssemblyNode;

public interface Loader {
	boolean canLoad(AssemblyNode node);

	Statement load(AssemblyNode node, Interpreter interpreter);
}
