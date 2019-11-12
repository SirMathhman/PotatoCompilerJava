package com.meti.compile;

import com.meti.interpret.ReturnStatement;
import com.meti.interpret.Statement;

class JSReturnUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof ReturnStatement;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        var returnStatement = (ReturnStatement) statement;
        var result = compiler.compile(returnStatement.value());
        return "return " + result + ";";
    }
}
