package com.meti;

import com.meti.lex.StringLexerInput;
import com.meti.lex.tokenizer.ContentTokenizer;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContentTokenizerTest {
	@Test
	void match() {
		var string = "test";
		var tokenizer = new ContentTokenizer();
		var input = new StringLexerInput(string)
				.extend(3);
		var result = tokenizer.match(input);
		assertTrue(result.isPresent());
		assertEquals("test", result.get().value());
	}
}
