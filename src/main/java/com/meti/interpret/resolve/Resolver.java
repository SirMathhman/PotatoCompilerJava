package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.Type;

public interface Resolver {
    boolean canResolve(Statement statement);

    Type resolve(Statement statement, Interpreter interpreter);
}
