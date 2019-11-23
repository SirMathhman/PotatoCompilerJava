package com.meti.assemble.node;

public class VariableNode implements Node {
    private final String name;

    public VariableNode(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}
