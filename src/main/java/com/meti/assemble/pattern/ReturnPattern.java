package com.meti.assemble.pattern;

import com.meti.assemble.node.AssemblyNode;
import com.meti.assemble.AssemblyState;
import com.meti.assemble.node.control.InlineReturnNode;
import com.meti.lexeme.match.struct.Keyword;
import com.meti.lexeme.match.struct.KeywordMatch;

public class ReturnPattern implements Pattern {
    @Override
    public boolean canAssemble(AssemblyState state) {
        return state.has(0, KeywordMatch.class) &&
                state.get(0, KeywordMatch.class).value().equals(Keyword.RETURN);
    }

    @Override
    public AssemblyNode assemble(AssemblyState state) {
        return new InlineReturnNode(state.sub(1).assemble());
    }
}
