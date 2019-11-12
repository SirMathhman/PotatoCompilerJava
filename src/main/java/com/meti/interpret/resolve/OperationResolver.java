package com.meti.interpret.resolve;

import com.meti.interpret.Interpreter;
import com.meti.interpret.statement.Operation;
import com.meti.interpret.statement.Statement;
import com.meti.interpret.type.Type;

public class OperationResolver implements Resolver {
    @Override
    public boolean canResolve(Statement statement) {
        return statement instanceof Operation;
    }

    @Override
    public Type resolve(Statement statement, Interpreter interpreter) {
        var operation = (Operation) statement;
        var beforeType = interpreter.resolve(operation.before());
        var afterType = interpreter.resolve(operation.after());
        if (!beforeType.equals(afterType)) {
            throw new IllegalArgumentException("Operation types of \"" + beforeType +
                    "\" and \"" + afterType + " are not equal.");
        }
        return beforeType;
    }
}
