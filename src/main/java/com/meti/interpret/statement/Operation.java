package com.meti.interpret.statement;

import com.meti.lexeme.match.struct.Valued;

public class Operation implements Statement {
    private final Valued operator;
    private final Statement before;
    private final Statement after;

    public Operation(Valued operator, Statement before, Statement after) {
        this.operator = operator;
        this.before = before;
        this.after = after;
    }

    public Statement before() {
        return before;
    }

    public Statement after() {
        return after;
    }
}
