package com.meti.interpret.statement;

import com.meti.interpret.type.Type;

public interface Variable {
    Type type();

    String name();

    boolean isMutable();
}
