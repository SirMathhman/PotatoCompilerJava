package com.meti;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DeclareTokenizerTest {
	@Test
	void immutable() {
		var string = "val";
		var tokenizer = new DeclareTokenizer();
		var optional = tokenizer.match(string);
		assertTrue(optional.isPresent());
		assertFalse(optional.get().value());
	}

	@Test
	void invalid() {
		var string = "test";
		var tokenizer = new DeclareTokenizer();
		var optional = tokenizer.match(string);
		assertTrue(optional.isEmpty());
	}

	@Test
	void mutable() {
		var string = "var";
		var tokenizer = new DeclareTokenizer();
		var optional = tokenizer.match(string);
		assertTrue(optional.isPresent());
		assertTrue(optional.get().value());
	}
}
