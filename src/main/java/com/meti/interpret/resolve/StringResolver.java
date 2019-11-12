package com.meti.interpret.resolve;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.value.ValueNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

public class StringResolver implements TypeResolver {
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
