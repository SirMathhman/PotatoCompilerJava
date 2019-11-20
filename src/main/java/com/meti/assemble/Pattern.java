package com.meti.assemble;

import com.meti.token.Token;

import java.util.Optional;

interface Pattern {
    Optional<Node> collect(Assembler assembler);

    void form(Token<?> next);

    Pattern copy();
}
