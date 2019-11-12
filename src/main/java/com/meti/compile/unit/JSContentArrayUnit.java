package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.statement.ContentArray;
import com.meti.interpret.statement.Statement;

import java.util.List;
import java.util.stream.Collectors;

public class JSContentArrayUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof ContentArray;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        var array = (ContentArray) statement;
        var values = array.values();
        var valueString = values.stream()
                .map(compiler::compile)
                .collect(Collectors.joining(","));
        return "[" + valueString + "]";

    }
}
