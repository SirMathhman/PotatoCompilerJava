package com.meti.assemble.node;

import com.meti.assemble.node.AssemblyNode;

public interface AssignmentNode extends AssemblyNode {
    boolean isMutable();

    String name();

    AssemblyNode value();
}
