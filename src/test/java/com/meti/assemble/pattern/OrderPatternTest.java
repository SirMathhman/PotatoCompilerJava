package com.meti.assemble.pattern;

import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.QuantityNode;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.ParenthesisToken;
import com.meti.lex.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderPatternTest {

	@Test
	void collect() {
		var pattern = new OrderPattern();
		var result = pattern.form(new ParenthesisToken(true))
				.form(new InlineToken<>(TokenType.INT, 10))
				.form(new ParenthesisToken(false))
				.collect(new PatternAssembler(new IntPattern()));
		assertTrue(result.isPresent());
		var order = (QuantityNode) result.get();
		var child = (IntNode) order.child();
		assertEquals(10, child.value());
	}
}