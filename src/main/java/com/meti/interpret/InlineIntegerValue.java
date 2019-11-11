package com.meti.interpret;

class InlineIntegerValue implements IntegerValue {
    private final int value;

    InlineIntegerValue(int value) {
        this.value = value;
    }

    @Override
    public Integer value() {
        return value;
    }

    @Override
    public Type type() {
        return PrimitiveType.INTEGER;
    }
}
