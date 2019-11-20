package com.meti.interpret.statement;

import com.meti.interpret.Variable;

public class DeclarationStatement implements Statement {
    private final boolean mutable;
    private final Variable variable;

    public DeclarationStatement(boolean mutable, Variable variable) {
        this.mutable = mutable;
        this.variable = variable;
    }

    public boolean isMutable() {
        return mutable;
    }

    public Variable variable() {
        return variable;
    }
}
