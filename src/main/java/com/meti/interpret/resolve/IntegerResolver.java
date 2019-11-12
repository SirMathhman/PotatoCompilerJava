package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.IntegerValue;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

public class IntegerResolver implements Resolver {
    @Override
    public boolean canResolve(Statement statement) {
        return statement instanceof IntegerValue;
    }

    @Override
    public Type resolve(Statement statement, Interpreter interpreter) {
        return PrimitiveType.INT;
    }
}
