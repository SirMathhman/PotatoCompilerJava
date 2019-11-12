package com.meti.compile;

import com.meti.interpret.Statement;
import com.meti.interpret.Value;

class JSValueUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof Value;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        var valueStatement = (Value<?>) statement;
        var value = valueStatement.value();
        if (value instanceof String) {
            return "\"" + valueStatement.value() + "\"";
        } else {
            return String.valueOf(value);
        }
    }
}
