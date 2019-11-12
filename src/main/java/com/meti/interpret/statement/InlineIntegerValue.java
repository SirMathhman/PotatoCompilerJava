package com.meti.interpret.statement;

import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

public class InlineIntegerValue implements IntegerValue {
    private final int value;

    public InlineIntegerValue(int value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public Type type() {
        return PrimitiveType.INT;
    }
}
