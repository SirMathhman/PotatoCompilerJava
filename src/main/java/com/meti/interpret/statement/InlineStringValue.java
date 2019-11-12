package com.meti.interpret.statement;

import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

public class InlineStringValue implements StringValue {
    private final String value;

    public InlineStringValue(String value) {
        this.value = value;
    }

    @Override
    public String value() {
		return value;
    }

    @Override
    public Type type() {
        return PrimitiveType.STRING;
    }
}
