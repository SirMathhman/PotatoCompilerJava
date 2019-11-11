package com.meti.interpret;

public interface Variable {
    Type type();

    String name();

    boolean isMutable();
}
