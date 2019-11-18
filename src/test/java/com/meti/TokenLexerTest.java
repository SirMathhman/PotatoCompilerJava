package com.meti;

import com.meti.lex.StringLexerInput;
import com.meti.token.ContentTokenizer;
import com.meti.token.DeclareTokenizer;
import com.meti.token.TokenLexer;
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
		assertTrue(list.get(0).valueAs(Boolean.class));
		assertEquals("x", list.get(1).valueAs(String.class));
	}
}