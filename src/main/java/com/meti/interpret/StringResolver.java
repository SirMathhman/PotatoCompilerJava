package com.meti.interpret;

import com.meti.assemble.AssemblyNode;
import com.meti.assemble.StringNode;

class StringResolver implements TypeResolver {
    @Override
    public boolean canResolve(AssemblyNode node) {
        return node instanceof StringNode   ;
    }

    @Override
    public Type resolve(AssemblyNode node, Interpreter interpreter) {
        return PrimitiveType.STRING;
    }
}
