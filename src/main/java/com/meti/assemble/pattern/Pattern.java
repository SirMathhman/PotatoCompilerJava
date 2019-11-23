package com.meti.assemble.pattern;

import com.meti.assemble.Assembler;
import com.meti.assemble.node.Node;
import com.meti.lex.token.Token;

import java.util.Optional;

public interface Pattern {
	Optional<Node> collect(Assembler assembler);

	Pattern copy();

	Pattern form(Token<?> next);

	void reset();
}
