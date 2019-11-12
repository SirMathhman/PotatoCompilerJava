package com.meti.interpret.resolve;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.value.IntegerNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

public class IntegerResolver implements TypeResolver {
    @Override
    public boolean canResolve(AssemblyNode node) {
        return node instanceof IntegerNode;
    }

    @Override
    public Type resolve(AssemblyNode node, Interpreter interpreter) {
        return PrimitiveType.INT;
    }
}
