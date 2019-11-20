package com.meti.interpret;

class DeclarationStatement implements Statement {
    private final boolean mutable;
    private final Variable variable;

    DeclarationStatement(boolean mutable, Variable variable) {
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
