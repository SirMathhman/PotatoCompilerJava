package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;
import com.meti.lex.token.TokenType;

import java.util.Optional;

public class IntPattern implements Pattern {
    private Token<?> current;

    @Override
    public Optional<Node> collect(Assembler assembler) {
        return Optional.ofNullable(current)
                .map(token -> token.valueAs(Integer.class))
                .map(IntNode::new);
    }

    @Override
    public Pattern form(Token<?> next) {
        if (next.type() == TokenType.INT) current = next;
        return this;
    }

    @Override
    public void reset() {
    }

    @Override
    public Pattern copy() {
        return new IntPattern();
    }
}
