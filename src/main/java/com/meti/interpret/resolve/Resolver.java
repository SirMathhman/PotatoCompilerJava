package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.Type;
import com.meti.interpret.statement.Statement;

public interface Resolver {
    boolean canResolve(Statement node);

    Type resolve(Statement node, Interpreter interpreter);
}
