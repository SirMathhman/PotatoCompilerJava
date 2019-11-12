package com.meti.interpret.statement;

public class InlineStatement implements Statement {
    private final String value;

    public InlineStatement(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }
}
