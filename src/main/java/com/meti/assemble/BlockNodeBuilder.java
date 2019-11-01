package com.meti.assemble;

import java.util.*;

public class BlockNodeBuilder {
    private String name;
    private Set<Modifier> modifiers;
    private Map<String, Type> arguments;
    private List<? extends AssemblyNode> children;

    public BlockNodeBuilder() {
        this("", new HashSet<>(), new HashMap<>(), new ArrayList<>());
    }

    public BlockNodeBuilder(String name, Set<Modifier> modifiers, Map<String, Type> arguments, List<? extends AssemblyNode> children) {
        this.name = name;
        this.modifiers = modifiers;
        this.arguments = arguments;
        this.children = children;
    }

    public BlockNodeBuilder withName(String name) {
        return new BlockNodeBuilder(name, modifiers, arguments, children);
    }

    public BlockNodeBuilder withModifiers(Set<Modifier> modifiers) {
        return new BlockNodeBuilder(name, modifiers, arguments, children);
    }

    public BlockNodeBuilder withArguments(Map<String, Type> arguments) {
        return new BlockNodeBuilder(name, modifiers, arguments, children);
    }

    public BlockNodeBuilder withChildren(List<? extends AssemblyNode> children) {
        return new BlockNodeBuilder(name, modifiers, arguments, children);
    }

    public BlockNode build() {
        return new BlockNode(name, modifiers, arguments, children);
    }
}