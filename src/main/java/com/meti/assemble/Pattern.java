package com.meti.assemble;

import com.meti.token.Token;

import java.util.Optional;

interface Pattern {
    Optional<Node> form(Token<?> next, Assembler assembler);
}
