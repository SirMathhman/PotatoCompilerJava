package com.meti.interpret;

class InlineStringValue implements StringValue {
    private final String value;

    InlineStringValue(String value) {
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
