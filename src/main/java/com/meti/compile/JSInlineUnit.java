package com.meti.compile;

import com.meti.interpret.statement.InlineStatement;
import com.meti.interpret.statement.Statement;

class JSInlineUnit implements Unit {
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
