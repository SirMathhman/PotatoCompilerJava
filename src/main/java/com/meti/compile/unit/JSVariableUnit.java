package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.InlineVariable;
import com.meti.interpret.Statement;

public class JSVariableUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof InlineVariable;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        var variable = (InlineVariable) statement;
        return state.alias(variable.name());
    }
}
