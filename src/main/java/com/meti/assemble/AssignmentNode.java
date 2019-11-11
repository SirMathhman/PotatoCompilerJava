package com.meti.assemble;

public interface AssignmentNode extends AssemblyNode {
    boolean isMutable();

    String name();

    AssemblyNode value();
}
