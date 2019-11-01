package com.meti.assemble;

public enum Primitive implements Type {
    INT("int"),
    STRING("string");

    private final String value;

    Primitive(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }
}
