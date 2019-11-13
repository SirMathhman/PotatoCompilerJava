package com.meti.interpret.statement;

import com.meti.interpret.type.Type;

public class InlineDeclaration implements Declaration {
    private final Type type;
    private final String name;
    private final boolean mutable;

    public InlineDeclaration(Type type, String name, boolean mutable) {
        this.type = type;
        this.name = name;
        this.mutable = mutable;
    }

    @Override
    public Type type() {
        return type;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean isMutable() {
        return mutable;
    }
}
