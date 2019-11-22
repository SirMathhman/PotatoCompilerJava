package com.meti.assemble;

import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;

import java.util.List;

public interface Assembler {
	default Node assembleChild(List<? extends Token<?>> tokens) {
		return copy().assemble(tokens);
	}

	Node assemble(List<? extends Token<?>> tokens);

	Assembler copy();
}
