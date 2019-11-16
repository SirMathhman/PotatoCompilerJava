package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IntegerTokenizerTest {
	@Test
	void matchInvalid() {
		var string = "test";
		var tokenizer = new IntegerTokenizer();
		var result = tokenizer.match(new StringLexerInput(string));
		assertTrue(result.isEmpty());
	}

	@Test
	void matchValid() {
		var string = "5";
		var tokenizer = new IntegerTokenizer();
		var result = tokenizer.match(new StringLexerInput(string));
		assertTrue(result.isPresent());
		assertEquals(5, result.get().value());
	}
}
