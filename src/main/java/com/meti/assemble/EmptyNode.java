package com.meti.assemble;

import java.util.Collections;
import java.util.List;

class EmptyNode implements AssemblyNode {
    @Override
    public List<? extends AssemblyNode> children() {
        return Collections.emptyList();
    }
}
