package com.meti.assemble;

import com.meti.token.Token;
import com.meti.token.TokenType;

import java.util.Optional;

class IntegerPattern implements Pattern {
    @Override
    public Optional<Node> form(Token<?> next, Assembler assembler) {
        return next.type().equals(TokenType.INTEGER) ?
                Optional.of(new IntegerNode(next.valueAs(Integer.class))) :
                Optional.empty();
    }
}
