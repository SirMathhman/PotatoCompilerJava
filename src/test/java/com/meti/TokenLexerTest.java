package com.meti;

import com.meti.lex.StringLexerInput;
import com.meti.token.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TokenLexerTest {

	@Test
	void lexise() {
		var string = "var x=10";
		var lexer = new TokenLexer(
		        new DeclareTokenizer(),
                new OperatorTokenizer(),
                new IntegerTokenizer(),
                new ContentTokenizer());
		var output = lexer.lexise(new StringLexerInput(string));
		var list = output.list();
		assertEquals(4, list.size());
		assertTrue(list.get(0).valueAs(Boolean.class));
		assertEquals("x", list.get(1).valueAs(String.class));
		assertEquals(Operator.ASSIGN, list.get(2).valueAs(Operator.class));
		assertEquals(10, list.get(3).valueAs(Integer.class));
	}
}