package com.meti;

import com.meti.lex.StringLexerInput;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringLexerInputTest {

	@Test
	void advance() {
		var input = new StringLexerInput("test")
				.advance();
		assertEquals("e", input.compute());
	}

	@Test
	void skipWhitespace() {
		var input = new StringLexerInput("  test")
				.skipWhitespace();
		assertEquals("t", input.compute());
	}

	@Test
	void trailing() {
		var input = new StringLexerInput("test");
		var trailing = input.trailing(3);
		assertTrue(trailing.isPresent());
		assertEquals("est", trailing.get());
	}

	@Test
	void compute() {
		var input = new StringLexerInput("test");
		assertEquals("t", input.compute());
	}

	@Test
	void extend() {
		var input = new StringLexerInput("test")
				.extend();
		assertEquals("te", input.compute());
	}

	@Test
	void hasMoreToScan() {
		var state = new StringLexerInput("test")
				.advance()
				.advance()
				.advance()
				.advance();
		assertFalse(state.hasMoreToScan());
	}
}