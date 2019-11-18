package com.meti.assemble;

import com.meti.token.Token;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class PatternAssembler implements Assembler {
    private final Set<? extends Pattern> patterns;

    PatternAssembler(Set<? extends Pattern> patterns) {
        this.patterns = patterns;
    }

    @Override
    public Node assemble(List<? extends Token<?>> tokens) {
        var queue = new LinkedList<Token<?>>(tokens);
        return null;
    }
}
