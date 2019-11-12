package com.meti.interpret;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.value.ValueNode;

class StringResolver implements TypeResolver {
	@Override
    public boolean canResolve(AssemblyNode node) {
		return node instanceof ValueNode &&
                ((ValueNode<?>) node).value() instanceof String;
	}

	@Override
	public Type resolve(AssemblyNode node, Interpreter interpreter) {
		return PrimitiveType.STRING;
	}
}
