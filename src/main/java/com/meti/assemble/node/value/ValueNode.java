package com.meti.assemble.node.value;

import com.meti.assemble.node.AssemblyNode;

public interface ValueNode<T> extends AssemblyNode {
    T value();
}
