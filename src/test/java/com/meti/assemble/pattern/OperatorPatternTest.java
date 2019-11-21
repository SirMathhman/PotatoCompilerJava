package com.meti.assemble.pattern;

import com.meti.assemble.node.IntNode;
import com.meti.assemble.node.OperationNode;
import com.meti.lex.token.InlineToken;
import com.meti.lex.token.Operator;
import com.meti.lex.token.TokenType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorPatternTest {

	@Test
	void collect() {
		var pattern = new OperatorPattern();
		var result = pattern.form(new InlineToken<>(10, TokenType.INT))
				.form(new InlineToken<>(Operator.ADD, TokenType.OPERATOR))
				.form(new InlineToken<>(20, TokenType.INT))
				.collect(new PatternAssembler(new IntPattern()))
				.orElseThrow();
		var node = (OperationNode) result;
		assertEquals(10, ((IntNode) node.node0()).value());
		assertEquals(20, ((IntNode) node.node1()).value());
		assertEquals(Operator.ADD, node.operator());
	}
}