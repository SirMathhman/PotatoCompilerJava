package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.struct.ArgumentMatch;

class IfPattern implements Pattern {
    @Override
    public boolean canAssemble(AssemblyState state) {
        return state.hasFirst(ContentMatch.class) &&
                state.getFirst(ContentMatch.class).value().equals("if");
    }

    @Override
    public AssemblyNode assemble(AssemblyState state) {
        var first = state.first(ArgumentMatch.class).orElseThrow();
        var last = state.index(2, ArgumentMatch.class).orElseThrow();
        var condition = state.sub(first + 1, last).assemble();
        var block = state.sub(last + 2, state.size() - 2).assemble();
        return new IfNode(condition, block);
    }
}
