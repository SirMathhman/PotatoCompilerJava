package com.meti.interpret;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.value.IntegerNode;

class IntegerResolver implements TypeResolver {
    @Override
    public boolean canResolve(AssemblyNode node) {
        return node instanceof IntegerNode;
    }

    @Override
    public Type resolve(AssemblyNode node, Interpreter interpreter) {
        return PrimitiveType.INTEGER;
    }
}
