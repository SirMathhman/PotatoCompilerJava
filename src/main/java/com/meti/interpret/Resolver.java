package com.meti.interpret;

interface Resolver {
    boolean canResolve(Statement node);

    Type resolve(Statement node);
}
