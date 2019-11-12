package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.statement.ReturnStatement;
import com.meti.interpret.statement.Statement;

public class JSReturnUnit implements Unit {
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
