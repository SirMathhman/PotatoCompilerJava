package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OperatorTokenizerTest {
	@Test
	void match() {
		var string = "+";
		var tokenizer = new OperatorTokenizer();
		var result = tokenizer.match(new StringLexerInput(string));
		assertTrue(result.isPresent());
		assertEquals(Operator.ADD, result.get().value());
	}
}
