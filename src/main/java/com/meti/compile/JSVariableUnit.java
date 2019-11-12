package com.meti.compile;

import com.meti.interpret.InlineVariable;
import com.meti.interpret.Statement;

class JSVariableUnit implements Unit {
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
