package com.meti.interpret;

import com.meti.assemble.node.ContentArrayNode;
import com.meti.interpret.resolve.Resolver;
import com.meti.interpret.statement.ContentArray;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.Type;

class ArrayResolver implements Resolver {
    @Override
    public boolean canResolve(Statement statement) {
        return statement instanceof ContentArray;
    }

    @Override
    public Type resolve(Statement statement, Interpreter interpreter) {
        var array = (ContentArray) statement;
        return array.values()
                .stream()
                .map(interpreter::resolve)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Cannot resolve type of empty array."));
    }
}
