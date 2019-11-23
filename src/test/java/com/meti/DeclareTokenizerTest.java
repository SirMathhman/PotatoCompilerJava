package com.meti;

import com.meti.lex.StringLexerInput;
import com.meti.lex.tokenizer.DeclareTokenizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeclareTokenizerTest {
	@Test
	void immutable() {
		var string = "val";
		var tokenizer = new DeclareTokenizer();
		var input = new StringLexerInput(string)
				.extend(2);
		var optional = tokenizer.match(input);
		assertTrue(optional.isPresent());
		assertFalse(optional.get().value());
	}

	@Test
	void invalid() {
		var string = "test";
		var tokenizer = new DeclareTokenizer();
		var input = new StringLexerInput(string)
				.extend(3);
		var optional = tokenizer.match(input);
		assertTrue(optional.isEmpty());
	}

	@Test
	void mutable() {
		var string = "var";
		var tokenizer = new DeclareTokenizer();
		var input = new StringLexerInput(string)
				.extend(2);
		var optional = tokenizer.match(input);
		assertTrue(optional.isPresent());
		assertTrue(optional.get().value());
	}
}
