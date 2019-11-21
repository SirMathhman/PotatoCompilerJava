package com.meti.assemble.pattern;

import com.meti.assemble.node.AllocNode;
import com.meti.assemble.node.IntNode;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AllocPatternTest {

	@Test
	void collect() {
		var node = new AllocPattern()
				.form(new InlineToken<>(true, TokenType.LIST))
				.form(new InlineToken<>(10, TokenType.INT))
				.form(new InlineToken<>(false, TokenType.LIST))
				.collect(new PatternAssembler(new IntPattern()));
		assertTrue(node.isPresent());
		var alloc = (AllocNode) node.get();
		var size = (IntNode) alloc.size();
		assertEquals(10, size.value());
	}
}