package com.meti.interpret;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.node.ContentArrayNode;
import com.meti.interpret.type.Type;

class ArrayResolver implements com.meti.interpret.resolve.TypeResolver {
    @Override
    public boolean canResolve(AssemblyNode node) {
        return node instanceof ContentArrayNode;
    }

    @Override
    public Type resolve(AssemblyNode node, Interpreter interpreter) {
        var array = (ContentArrayNode) node;
        return array.value()
                .stream()
                .map(interpreter::resolve)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Cannot resolve type of empty array."));
    }
}
