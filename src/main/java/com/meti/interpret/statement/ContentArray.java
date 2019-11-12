package com.meti.interpret.statement;

import java.util.List;

public class ContentArray implements Statement {
    private final List<Statement> values;

    public ContentArray(List<Statement> values) {
        this.values = values;
    }

    public List<Statement> values() {
        return values;
    }
}
