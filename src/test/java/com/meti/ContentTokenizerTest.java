package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ContentTokenizerTest {
	@Test
	void match() {
		var string = "test";
		var tokenizer = new ContentTokenizer();
		var result = tokenizer.match(string);
		assertTrue(result.isPresent());
		assertEquals("test", result.get().value());
	}
}
