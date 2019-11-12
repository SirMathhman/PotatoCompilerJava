package com.meti.compile;

import com.meti.interpret.statement.Operation;
import com.meti.interpret.statement.Statement;

class JSOperationUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof Operation;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        return null;
    }
}
