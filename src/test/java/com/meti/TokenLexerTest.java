package com.meti;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokenLexerTest {

	@Test
	void lexise() {
		var string = "var x";
		var lexer = new TokenLexer(List.of(new DeclareTokenizer(), new ContentTokenizer()));
		var output = lexer.lexise(new StringLexerInput(string));
		var list = output.list();
		assertEquals(2, list.size());
		assertTrue(list.get(0).as(Boolean.class));
		assertEquals("x", list.get(1).as(String.class));
	}
}