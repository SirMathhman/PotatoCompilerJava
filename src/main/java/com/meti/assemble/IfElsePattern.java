package com.meti.assemble;

import com.meti.lexeme.match.format.ContentMatch;
import com.meti.lexeme.match.struct.ArgumentMatch;

class IfElsePattern implements Pattern {
    @Override
    public boolean canAssemble(AssemblyState state) {
        return state.hasFirst(ContentMatch.class) &&
                state.getFirst(ContentMatch.class).value().equals("if") &&
                state.has(ContentMatch.class, match -> match.value().equals("else"));
    }

    @Override
    public AssemblyNode assemble(AssemblyState state) {
        var first = state.first(ArgumentMatch.class).orElseThrow();
        var last = state.index(2, ArgumentMatch.class).orElseThrow();
        var condition = state.sub(first + 1, last).assemble();
        var elseIndex = state.first(ContentMatch.class, match -> match.value().equals("else")).orElseThrow();
        var ifBlock = state.sub(last + 2, elseIndex - 1).assemble();
        var elseBlock = state.sub(elseIndex + 2, state.size() - 1).assemble();
        return new IfElseNode(condition, ifBlock, elseBlock);
    }
}
