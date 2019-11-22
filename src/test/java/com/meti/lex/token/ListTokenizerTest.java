package com.meti.lex.token;

import com.meti.lex.StringLexerInput;
import com.meti.lex.tokenizer.ListTokenizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ListTokenizerTest {
	@Test
	void matchClose() {
		var tokenizer = new ListTokenizer();
		var result = tokenizer.match(new StringLexerInput("]"));
		assertTrue(result.isPresent());
		assertFalse(result.get().valueAs(Boolean.class));
	}

	@Test
	void matchOpen() {
		var tokenizer = new ListTokenizer();
		var result = tokenizer.match(new StringLexerInput("["));
		assertTrue(result.isPresent());
		assertTrue(result.get().valueAs(Boolean.class));
	}
}