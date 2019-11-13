package com.meti.interpret.load;

import com.meti.assemble.node.ArrayIndexNode;
import com.meti.assemble.node.AssemblyNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.ArrayIndex;
import com.meti.interpret.statement.Statement;

public class ArrayIndexLoader implements Loader {
	@Override
	public boolean canLoad(AssemblyNode node) {
		return node instanceof ArrayIndexNode;
	}

	@Override
	public Statement load(AssemblyNode node, Interpreter interpreter) {
		var arrayIndex = (ArrayIndexNode) node;
		var content = interpreter.loadChild(arrayIndex.content());
		var index = interpreter.loadChild(arrayIndex.index());
		return new ArrayIndex(content, index);
	}
}
