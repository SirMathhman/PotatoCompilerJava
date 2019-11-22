package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.interpret.statement.VariableStatement;
import com.meti.interpret.statement.Statement;

public class VariableUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof VariableStatement;
    }

    @Override
    public String compile(Statement statement, Compiler compiler) {
        var variable = (VariableStatement) statement;
        var name = variable.name();
        return compiler.generator().alias(name);
    }
}
