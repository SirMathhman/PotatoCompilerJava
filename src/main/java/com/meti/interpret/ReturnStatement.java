package com.meti.interpret;

public class ReturnStatement implements Statement {
    private final Statement value;

    ReturnStatement(Statement value) {
        this.value = value;
    }

    public Statement value() {
        return value;
    }
}
