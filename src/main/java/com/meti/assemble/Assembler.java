package com.meti.assemble;

import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;

import java.util.List;

public interface Assembler {
    Node assemble(List<? extends Token<?>> tokens);

    Assembler copy();
}
