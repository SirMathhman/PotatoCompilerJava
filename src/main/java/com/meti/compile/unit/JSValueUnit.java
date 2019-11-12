package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.Statement;
import com.meti.interpret.Value;

public class JSValueUnit implements Unit {
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
