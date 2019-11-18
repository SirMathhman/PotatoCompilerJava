package com.meti.assemble;

class DeclarationNode implements Node {
    private final boolean mutable;
    private final String name;
    private final Node value;

    DeclarationNode(boolean mutable, String name, Node value) {
        this.value = value;
        this.mutable = mutable;
        this.name = name;
    }

    public boolean mutable() {
        return mutable;
    }

    public String name() {
        return name;
    }

    public Node value() {
        return value;
    }
}
