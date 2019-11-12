package com.meti.interpret.statement;

import java.util.List;

public class ContentArray implements Statement {
    private final List<? extends Statement> values;

    public ContentArray(List<? extends Statement> values) {
        this.values = values;
    }

    public List<? extends Statement> values() {
        return values;
    }
}
