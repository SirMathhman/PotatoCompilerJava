package com.meti.transform;

import com.meti.interpret.statement.FunctionStatement;
import com.meti.interpret.statement.Statement;

class FunctionApplicator implements Applicator {
    @Override
    public boolean canApply(Statement statement) {
        return statement instanceof FunctionStatement;
    }

    @Override
    public Statement apply(Statement statement, Transformer transformer) {
        var function = (FunctionStatement) statement;
        return statement;
    }
}
