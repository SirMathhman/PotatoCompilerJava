package com.meti.interpret;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.StringNode;

class ValueLoader implements Loader {
	@Override
	public boolean canLoad(AssemblyNode node) {
		return node instanceof StringNode;
	}

	@Override
	public Statement load(AssemblyNode node, Interpreter interpreter) {
		var stringNode = (StringNode) node;
		return new InlineStringValue(stringNode);
	}
}
