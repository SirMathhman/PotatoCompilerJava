package com.meti.interpret.type;

public class AnyType implements Type {
    public static final Type INSTANCE = new AnyType();

    private AnyType() {
    }

    @Override
    public String[] value() {
        return new String[]{"any"};
    }
}
