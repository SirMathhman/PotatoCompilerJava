package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.statement.Operation;
import com.meti.interpret.statement.Statement;

public class JSOperationUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof Operation;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        return null;
    }
}
