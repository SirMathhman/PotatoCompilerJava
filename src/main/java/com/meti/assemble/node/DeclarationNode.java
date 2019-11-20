package com.meti.assemble.node;

import java.util.Optional;

public class DeclarationNode implements Node {
    private final boolean mutable;
    private final String name;
    private final Node value;

    public DeclarationNode(boolean mutable, String name, Node value) {
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

    public Optional<Node> value() {
        return Optional.ofNullable(value);
    }
}
