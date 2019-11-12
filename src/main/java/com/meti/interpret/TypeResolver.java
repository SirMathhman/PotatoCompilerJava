package com.meti.interpret;

import com.meti.assemble.node.AssemblyNode;

interface TypeResolver {
    boolean canResolve(AssemblyNode node);

    Type resolve(AssemblyNode node, Interpreter interpreter);
}
