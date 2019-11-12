package com.meti.interpret.load;

import com.meti.assemble.node.AssemblyNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;

public interface Loader {
	boolean canLoad(AssemblyNode node);

	Statement load(AssemblyNode node, Interpreter interpreter);
}
