package com.meti.assemble;

public enum Primitive implements Type {
    INT("int", "", ""),
    STRING("string", "\"", "\"");

    private final String value;
    private final String pre;
    private final String post;

    Primitive(String value, String pre, String post) {
        this.value = value;
        this.pre = pre;
        this.post = post;
    }

    @Override
    public String format(String value) {
        return pre + value + post;
    }

    @Override
    public String value() {
        return value;
    }
}
