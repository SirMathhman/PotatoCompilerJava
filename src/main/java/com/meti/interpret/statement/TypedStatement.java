package com.meti.interpret.statement;

import com.meti.interpret.Type;

public interface TypedStatement extends Statement {
    Type type();
}
