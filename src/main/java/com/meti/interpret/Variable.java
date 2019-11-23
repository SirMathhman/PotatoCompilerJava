package com.meti.interpret;

public class Variable {
    private final Type type;
    private final String name;

    public Variable(Type type, String name) {
        this.type = (type == null) ? Primitive.ANY : type;
        this.name = name;
    }

    public Type type() {
        return type;
    }

    public String name(){
        return name;
    }
}
