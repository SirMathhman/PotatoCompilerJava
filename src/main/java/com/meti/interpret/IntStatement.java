package com.meti.interpret;

class IntStatement implements TypedStatement {
    private final int value;

    IntStatement(int value) {
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
