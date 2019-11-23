package com.meti.lex.token;

import com.meti.lex.StringLexerInput;
import com.meti.lex.tokenizer.ParenthesisTokenizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParenthesisTokenizerTest {

	@Test
	void matchClose() {
		var tokenizer = new ParenthesisTokenizer();
		var token = tokenizer.match(new StringLexerInput(")"));
		assertTrue(token.isPresent());
		assertFalse(token.get().valueAs(Boolean.class));
	}

	@Test
	void matchOpen() {
		var tokenizer = new ParenthesisTokenizer();
		var token = tokenizer.match(new StringLexerInput("("));
		assertTrue(token.isPresent());
		assertTrue(token.get().valueAs(Boolean.class));
	}
}