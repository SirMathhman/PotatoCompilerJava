package com.meti.interpret.resolve;

import com.meti.interpret.Type;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.statement.TypedStatement;

public class TypedResolver implements Resolver {
    @Override
    public boolean canResolve(Statement node) {
        return node instanceof TypedStatement;
    }

    @Override
    public Type resolve(Statement node) {
        return ((TypedStatement) node).type();
    }
}
