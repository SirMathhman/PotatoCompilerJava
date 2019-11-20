package com.meti.interpret;

import java.util.List;

class GroupStatement implements Statement {
    private final List<? extends Statement> children;

    public GroupStatement(List<? extends Statement> children) {
        this.children = children;
    }

    public List<? extends Statement> children() {
        return children;
    }
}
