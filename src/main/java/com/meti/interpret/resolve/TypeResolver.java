package com.meti.interpret.resolve;

import com.meti.assemble.node.AssemblyNode;
import com.meti.interpret.Interpreter;
import com.meti.interpret.type.Type;

public interface TypeResolver {
    boolean canResolve(AssemblyNode node);

    Type resolve(AssemblyNode node, Interpreter interpreter);
}
