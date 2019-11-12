package com.meti.interpret;

import com.meti.assemble.node.AssemblyNode;

public interface Loader {
	boolean canLoad(AssemblyNode node);

	Statement load(AssemblyNode node, Interpreter interpreter);
}
