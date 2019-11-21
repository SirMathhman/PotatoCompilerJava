package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.statement.Statement;

public interface Resolver {
    boolean canResolve(Statement statement);

    Type resolve(Statement statement, Interpreter interpreter);
}
