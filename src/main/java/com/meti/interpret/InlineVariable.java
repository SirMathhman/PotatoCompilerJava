package com.meti.interpret;

public class InlineVariable implements Statement {
    private final String name;

    public InlineVariable(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
