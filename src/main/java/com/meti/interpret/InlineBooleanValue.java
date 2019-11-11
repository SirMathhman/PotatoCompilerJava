package com.meti.interpret;

class InlineBooleanValue implements BooleanValue {
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
