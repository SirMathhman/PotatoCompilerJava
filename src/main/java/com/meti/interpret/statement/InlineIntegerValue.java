package com.meti.interpret.statement;

import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

import java.util.function.Predicate;

public class InlineIntegerValue implements IntegerValue {
    private final int value;

    public InlineIntegerValue(int value) {
        this.value = value;
    }

    @Override
    public void replaceAll(Predicate<? super Statement> test, Statement replacement) {

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
