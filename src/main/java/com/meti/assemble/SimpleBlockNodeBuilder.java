package com.meti.assemble;

import java.util.*;

public class SimpleBlockNodeBuilder implements BlockNodeBuilder {
    private final String name;
    private final Set<Modifier> modifiers;
    private final Map<String, Type> arguments;
    private final List<? extends AssemblyNode> children;

    public SimpleBlockNodeBuilder() {
        this("", new HashSet<>(), new HashMap<>(), new ArrayList<>());
    }

    private SimpleBlockNodeBuilder(String name, Set<Modifier> modifiers, Map<String, Type> arguments, List<? extends AssemblyNode> children) {
        this.name = name;
        this.modifiers = modifiers;
        this.arguments = arguments;
        this.children = children;
    }

    @Override
    public BlockNodeBuilder withName(String name) {
        return new SimpleBlockNodeBuilder(name, modifiers, arguments, children);
    }

    @Override
    public BlockNodeBuilder withModifiers(Set<Modifier> modifiers) {
        return new SimpleBlockNodeBuilder(name, modifiers, arguments, children);
    }

    @Override
    public BlockNodeBuilder withArguments(Map<String, Type> arguments) {
        return new SimpleBlockNodeBuilder(name, modifiers, arguments, children);
    }

    @Override
    public BlockNodeBuilder withChildren(List<? extends AssemblyNode> children) {
        return new SimpleBlockNodeBuilder(name, modifiers, arguments, children);
    }

    @Override
    public AssemblyNode build() {
        return new SimpleBlockNode(name, modifiers, arguments, children);
    }
}