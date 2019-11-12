package com.meti.interpret;

import com.meti.assemble.AssemblyNode;

interface TypeResolver {
    boolean canResolve(AssemblyNode node);

    Type resolve(AssemblyNode node, Interpreter interpreter);
}
