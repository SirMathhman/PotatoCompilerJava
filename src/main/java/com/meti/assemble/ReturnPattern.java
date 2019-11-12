package com.meti.assemble;

import com.meti.lexeme.match.struct.Keyword;
import com.meti.lexeme.match.struct.KeywordMatch;

import java.security.Key;

class ReturnPattern implements Pattern {
    @Override
    public boolean canAssemble(AssemblyState state) {
        return state.has(0, KeywordMatch.class) &&
                state.get(0, KeywordMatch.class).value().equals(Keyword.RETURN);
    }

    @Override
    public AssemblyNode assemble(AssemblyState state) {
        return new ReturnNode(state.sub(1).assemble());
    }
}
