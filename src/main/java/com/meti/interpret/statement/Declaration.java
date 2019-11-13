package com.meti.interpret.statement;

import com.meti.interpret.type.Type;

public interface Declaration {
    Type type();

    String name();

    boolean isMutable();
}
