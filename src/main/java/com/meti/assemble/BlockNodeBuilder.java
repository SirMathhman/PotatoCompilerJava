package com.meti.assemble;

import java.util.List;
import java.util.Map;
import java.util.Set;

interface BlockNodeBuilder {
    BlockNodeBuilder setName(String name);

    BlockNodeBuilder setModifiers(Set<Modifier> modifiers);

    BlockNodeBuilder setParameters(Map<String, Type> arguments);

    BlockNodeBuilder setChildren(List<? extends AssemblyNode> children);

    AssemblyNode build();
}
