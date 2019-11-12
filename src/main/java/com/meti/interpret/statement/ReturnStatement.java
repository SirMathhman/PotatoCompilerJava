package com.meti.interpret.statement;

public class ReturnStatement implements Statement {
    private final Statement value;

    public ReturnStatement(Statement value) {
        this.value = value;
    }

    public Statement value() {
        return value;
    }
}
