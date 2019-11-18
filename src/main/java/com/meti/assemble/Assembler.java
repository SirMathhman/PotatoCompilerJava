package com.meti.assemble;

import com.meti.token.Token;

import java.util.List;

interface Assembler {
    Node assemble(List<? extends Token<?>> tokens);
}
