package com.meti.interpret;

class TypedResolver implements Resolver {
    @Override
    public boolean canResolve(Statement node) {
        return node instanceof TypedStatement;
    }

    @Override
    public Type resolve(Statement node) {
        return ((TypedStatement) node).type();
    }
}
