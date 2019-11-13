package com.meti.interpret.statement;

import com.meti.interpret.type.PrimitiveType;
import com.meti.interpret.type.Type;

import java.util.function.Predicate;

public class InlineBooleanValue implements BooleanValue {
    private boolean value;

    public InlineBooleanValue(boolean value) {
        this.value = value;
    }

    @Override
    public void replaceAll(Predicate<? super Statement> test, Statement replacement) {
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
