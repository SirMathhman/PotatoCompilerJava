package com.meti.assemble;

import com.meti.token.Token;
import com.meti.token.TokenType;

import java.util.Optional;

class IntegerPattern implements Pattern {
    private Token<?> current;

    @Override
    public Optional<Node> collect(Assembler assembler) {
        return Optional.ofNullable(current)
                .map(token -> token.valueAs(Integer.class))
                .map(IntegerNode::new);
    }

    @Override
    public void form(Token<?> next) {
        if (next.type().equals(TokenType.INTEGER)) current = next;
    }

    @Override
    public Pattern copy() {
        return new IntegerPattern();
    }
}
