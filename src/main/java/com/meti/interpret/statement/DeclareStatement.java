package com.meti.interpret.statement;

import com.meti.interpret.Variable;

public class DeclareStatement implements Statement {
    private final boolean mutable;
    private final Variable variable;

    public DeclareStatement(boolean mutable, Variable variable) {
        this.mutable = mutable;
        this.variable = variable;
    }

    public boolean mutable() {
        return mutable;
    }

    public Variable variable() {
        return variable;
    }
}
