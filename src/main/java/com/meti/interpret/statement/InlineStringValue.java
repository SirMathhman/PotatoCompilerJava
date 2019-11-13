package com.meti.interpret.statement;

import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

import java.util.function.Predicate;

public class InlineStringValue implements StringValue {
    private final String value;

    public InlineStringValue(String value) {
        this.value = value;
    }

    @Override
    public void replaceAll(Predicate<? super Statement> test, Statement replacement) {

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
