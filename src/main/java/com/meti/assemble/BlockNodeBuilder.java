package com.meti.assemble;

import java.util.List;
import java.util.Map;
import java.util.Set;

interface BlockNodeBuilder {
    BlockNodeBuilder withName(String name);

    BlockNodeBuilder withModifiers(Set<Modifier> modifiers);

    BlockNodeBuilder withArguments(Map<String, Type> arguments);

    BlockNodeBuilder withChildren(List<? extends AssemblyNode> children);

    AssemblyNode build();
}
