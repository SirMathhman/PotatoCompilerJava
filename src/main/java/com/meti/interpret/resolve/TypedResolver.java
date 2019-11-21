package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.statement.TypedStatement;

public class TypedResolver implements Resolver {
    @Override
    public boolean canResolve(Statement statement) {
        return statement instanceof TypedStatement;
    }

    @Override
    public Type resolve(Statement statement, Interpreter interpreter) {
        return ((TypedStatement) statement).type();
    }
}
