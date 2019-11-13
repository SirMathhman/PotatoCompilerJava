package com.meti.compile.unit;

import com.meti.compile.Compiler;
import com.meti.compile.CompilerState;
import com.meti.compile.Unit;
import com.meti.interpret.statement.InlineStatement;
import com.meti.interpret.statement.Statement;

public class JSInlineUnit implements Unit {
    @Override
    public boolean canCompile(Statement statement) {
        return statement instanceof InlineStatement;
    }

    @Override
    public String compile(Statement statement, CompilerState state, Compiler compiler) {
        var inline = (InlineStatement) statement;
        return state.alias(inline.value());
    }
}
