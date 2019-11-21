package com.meti.interpret.evaluate;

import com.meti.interpret.statement.Statement;

public class VariableStatement implements Statement {
    private final String name;

    public VariableStatement(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
