package com.meti.interpret.statement;

import com.meti.interpret.Primitive;
import com.meti.interpret.Type;

public class IntStatement implements PrimitiveStatement {
    private final int value;

    public IntStatement(int value) {
        this.value = value;
    }

    @Override
    public Type type() {
        return Primitive.INT;
    }

    public int value() {
        return value;
    }
}
