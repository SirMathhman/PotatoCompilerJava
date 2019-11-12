package com.meti.assemble.pattern;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.AssemblyState;
import com.meti.assemble.BooleanNode;
import com.meti.lexeme.match.primitive.BooleanMatch;

class BooleanPattern implements Pattern {
    @Override
    public boolean canAssemble(AssemblyState state) {
        return state.size() == 1 && state.has(BooleanMatch.class);
    }

    @Override
    public AssemblyNode assemble(AssemblyState state) {
        return new BooleanNode(state.get(0, BooleanMatch.class).value());
    }
}
