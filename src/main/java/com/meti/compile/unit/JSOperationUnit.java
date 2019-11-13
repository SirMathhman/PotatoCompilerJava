package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.statement.Operation;
import com.meti.interpret.statement.Statement;
import com.meti.lexeme.match.struct.Valued;

public class JSOperationUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof Operation;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        var operation = (Operation) statement;
        var operator = operation.operator();
        var beforeString = compiler.compile(operation.before());
        var afterString = compiler.compile(operation.after());
        return beforeString + operator.value() + afterString;
    }
}
