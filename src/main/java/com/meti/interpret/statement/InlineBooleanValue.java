package com.meti.interpret.statement;

import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

public class InlineBooleanValue implements BooleanValue {
    private boolean value;

    public InlineBooleanValue(boolean value) {
        this.value = value;
    }

    @Override
    public Type type() {
        return PrimitiveType.BOOLEAN;
    }

    @Override
    public Boolean value() {
        return value;
    }
}
